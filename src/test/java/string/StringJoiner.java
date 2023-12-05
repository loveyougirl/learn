package string;

import java.util.Objects;

public class StringJoiner {
    //拼接后的字符串的前缀部分，在构造函数中通过传递参数指定，如果没有提供那么这里默认是空字符串
    private final String prefix;
    //拼接字符串时使用的分隔符，如果没传递，同上为空字符串
    private final String delimiter;
    //拼接后字符串，同上
    private final String suffix;
    //拼接结果
    private StringBuilder value;
    //前缀和后缀的组合
    private String emptyValue;

    public StringJoiner(CharSequence delimiter) {
        this(delimiter, "", "");
    }

    public StringJoiner(CharSequence delimiter,
                        CharSequence prefix,
                        CharSequence suffix) {
        Objects.requireNonNull(prefix, "The prefix must not be null");
        Objects.requireNonNull(delimiter, "The delimiter must not be null");
        Objects.requireNonNull(suffix, "The suffix must not be null");
        // make defensive copies of arguments
        this.prefix = prefix.toString();
        this.delimiter = delimiter.toString();
        this.suffix = suffix.toString();
        this.emptyValue = this.prefix + this.suffix;
    }
}
