package com.delin.collect;

import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.compress.utils.Sets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUtils {

    /**
     * 按照指令条件将list转换成map
     * @param collect 集合
     * @param key key
     * @param valueCommand value指令
     * @param <E> 输入类型
     * @param <K> key的类型
     * @return  Map<K, T>
     */
    public static <E, K, V> Map<K, V> convertMap(Collection<E> collect, Function<? super E, ? extends K> key,
                                                 Function<? super E, ? extends V> valueCommand) {
        if (CollectionUtils.isEmpty(collect)) {
            return Maps.newHashMap();
        }
        return collect.stream().collect(Collectors.toMap(key, valueCommand));
    }

    /**
     * 按照指令将集合转换成set
     * @param collect
     * @param valueCommand
     * @return
     * @param <E>
     * @param <V>
     */
    public static <E, V> Set<V> convertSet(Collection<E> collect, Function<? super E, ? extends V> valueCommand) {
        if (CollectionUtils.isEmpty(collect)) {
            return Sets.newHashSet();
        }
        return collect.stream().map(valueCommand).collect(Collectors.toSet());
    }

    /**
     * 按照指令将集合转换成set
     * @param collect
     * @param valueCommand
     * @return
     * @param <E>
     * @param <V>
     */
    public static <E, V> Set<V> convertSet(Collection<E> collect, Predicate<? super E> filterCommand, Function<? super E, ? extends V> valueCommand) {
        if (CollectionUtils.isEmpty(collect)) {
            return Sets.newHashSet();
        }
        return collect.stream().filter(filterCommand).map(valueCommand).collect(Collectors.toSet());
    }

    /**
     * 按照指令条件将list转换成map
     * @param collect 集合
     * @param key key
     * @param valueCommand value指令
     * @param mergeCommand 合并的指令，当key重复时通过指令选择value
     * @param <E> 输入类型
     * @param <K> key的类型
     * @return  Map<K, T>
     */
    public static <E, K, V> Map<K, V> convertMap(Collection<E> collect, Function<? super E, ? extends K> key,
                                                 Function<? super E, ? extends V> valueCommand,
                                                 BinaryOperator<V> mergeCommand) {
        if (CollectionUtils.isEmpty(collect)) {
            return Maps.newHashMap();
        }
        return collect.stream().collect(Collectors.toMap(key, valueCommand, mergeCommand));
    }

    public static <E> List<E> convertList(Collection<E> collect) {
        return new ArrayList<>(collect);
    }

    public static <E> List<E> convertList(E[] array) {
        return Stream.of(array).collect(Collectors.toList());
    }

    /**
     * 按照指定条件分组
     * @param collect 集合
     * @param command 分组的指令
     * @param <E> 输入类型
     * @param <K> key的类型
     * @return Map<K, List<T>>
     */
    public static <E, K> Map<K, List<E>> grouping(Collection<E> collect, Function<? super E, ? extends K> command) {
        if (CollectionUtils.isEmpty(collect)) {
            return Maps.newHashMap();
        }
        return collect.stream().collect(Collectors.groupingBy(command));
    }

    /**
     * 按照指定条件分组
     * @param array 集合
     * @param command 分组的指令
     * @param <E> 输入类型
     * @param <K> key的类型
     * @return Map<K, List<T>>
     */
    public static <E, K> Map<K, List<E>> grouping(E[] array, Function<? super E, ? extends K> command) {
        return grouping(convertList(array), command);
    }

    public static <E, C> List<C> map(Collection<E> collect, Function<? super E, ? extends C> command) {
        if (CollectionUtils.isEmpty(collect)) {
            return Lists.newArrayList();
        }
        return collect.stream().map(command).collect(Collectors.toList());
    }

    public static <E, C> List<C> map(E[] array, Function<? super E, ? extends C> command) {
        return map(convertList(array), command);
    }



    public static <E, C> List<C> mappingThenFilter(Collection<E> collect, Function<? super E, ? extends C> mapCommand, Predicate<? super C> filterCommand) {
        if (CollectionUtils.isEmpty(collect)) {
            return Lists.newArrayList();
        }
        return collect.stream().map(mapCommand).filter(filterCommand).collect(Collectors.toList());
    }

    public static <E> List<E> peek(Collection<E> collect, Consumer<? super E> command) {
        if (CollectionUtils.isEmpty(collect)) {
            return Lists.newArrayList();
        }
        return collect.stream().peek(command).collect(Collectors.toList());
    }

    public static <E> List<E> filter(Collection<E> collect, Predicate<? super E> command) {
        if (CollectionUtils.isEmpty(collect)) {
            return Lists.newArrayList();
        }
        return collect.stream().filter(command).collect(Collectors.toList());
    }

    public static <E> List<E> filterThenPeek(Collection<E> collect, Predicate<? super E> filterCommand, Consumer<? super E> mapCommand) {
        if (CollectionUtils.isEmpty(collect)) {
            return Lists.newArrayList();
        }
        return collect.stream().filter(filterCommand).peek(mapCommand).collect(Collectors.toList());
    }

    public static <E, C> List<C> filterThenMapping(Collection<E> collect, Predicate<? super E> filterCommand, Function<? super E, ? extends C> mapCommand) {
        if (CollectionUtils.isEmpty(collect)) {
            return Lists.newArrayList();
        }
        return collect.stream().filter(filterCommand).map(mapCommand).collect(Collectors.toList());
    }

    public static <E, K, V> Map<K, V> filterThenConvertMap(Collection<E> collect, Predicate<? super E> command,
                                                    Function<? super E, ? extends K> keyCommand, Function<? super E, ? extends V> valueCommand) {
        if (CollectionUtils.isEmpty(collect)) {
            return Maps.newHashMap();
        }
        return collect.stream().filter(command).collect(Collectors.toMap(keyCommand, valueCommand));
    }

    public static <E>  Set<E> filterThenConvertSet(Collection<E> collect, Predicate<? super E> command) {
        if (CollectionUtils.isEmpty(collect)) {
            return Sets.newHashSet();
        }
        return collect.stream().filter(command).collect(Collectors.toSet());
    }

    /**
     * 将list按照指令去重
     * @param collect 集合
     * @param keyCommand 指令
     * @param <E> 输入类型
     * @param <K> 去重指令
     * @return List<E></>
     */
    public static <E, K> List<E> distinct(Collection<E> collect, Function<? super E, ? extends K> keyCommand) {
        if (CollectionUtils.isEmpty(collect)) {
            return Lists.newArrayList();
        }
        return convertList(convertMap(collect, keyCommand, Function.identity()).values());
    }
}
