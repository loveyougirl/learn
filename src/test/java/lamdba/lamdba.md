    //count
    public Long queryCount(String id) {
        Long count = mapper.selectCount(new LambdaQueryWrapper<Entity>().eq(Entity::getId, id));
        return count;
    }

    //total
    public BigDecimal queryTotal(String id) {
        Entity entity = new Entity();
        entity.setId(id);
        List<Entity> list = mapper.findList(entity);
        BigDecimal total = list.stream()
                .map(Entity::getTotal)字段
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return total;
    }

    //groupby name 后 合并 金额
    public List<T> query() {
        List<Entity> list = mapper.findList(param);
        Map<String, Object> collect = list.parallelStream().collect(Collectors
                .groupingBy(Entity::getName,
                        Collectors.collectingAndThen(Collectors.toList(), m -> {
                            BigDecimal amount = m.parallelStream()
                                    .map(Entity::getAmt).filter(Objects::nonNull)
                                    .reduce(BigDecimal.ZERO, BigDecimal::add);
                            return amount;
                        })));
        return T;
    }

    //通常用来国际化
    public boolean english(){
        return "en".equals(LocaleContextHolder.getLocale().getLanguage());
    }