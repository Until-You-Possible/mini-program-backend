package com.lin.missyou.mark;


// 关于optional
// optional类是Java8的新特性 可以理解是一个为null的对象，如果值存在 则isPresent() 方法返回true, 条用get()方法会返回该对象。
// optional是个容器，可以保存类型T的值，或者仅仅保存null，不用显示的检测空值，很好的解决了空指针的异常


public class testOptional {
    // 访问optional的值
    // String name = "arthur";
    // Optional<String> optionalString = Optional.of(name);
    // String tesName = optionalString.get();

    // 可以使用of()和ofNullable()方法创建包含值的Optional。两个方法的不同之处在于如果你把null作为参数传递进去，of方法会抛出NullpointerException错误
    // 因此明确对象不为null的时候 用of()方法
    // 如果对象可能是null或者是非null 使用 ofNullable()方法
    // User user = new User("john@gmail.com", "1234");
    // Optional<User> optionalUser = Optional.ofNullable(user);
    // 因为optional传入的值为null的时候 也会抛出异常 因此首先要验证是否有值
    //if (opt.isPresent()) {
        // 如果值存在..
    //}

    // orElse()
    //    @Test
    //    public void whenEmptyValue_thenReturnDefault() {
    //        User user = null;
    //        User user2 = new User("anna@gmail.com", "1234");
    //        User result = Optional.ofNullable(user).orElse(user2);
    //
    //        assertEquals(user2.getEmail(), result.getEmail());
    //    }
    // 这里 user 对象是空的，所以返回了作为默认值的 user2。
    // 如果对象的初始值不是 null，那么默认值会被忽略：

    // 返回异常
    // orElseThrow 对象为空的时候抛出异常
    // 可以自定义这样的异常
}