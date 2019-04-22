package com.message.fhl.config;

public class ThreadContext {

    private static final ThreadLocal<ThreadContext> THREAD_CONTEXT = new ThreadLocal<>();
    private String customer;
    public static final String DEFAULT_CUSTOMER = "default";

    public static String getCustomer() {
        if (THREAD_CONTEXT.get() == null || THREAD_CONTEXT.get().customer == null) {
            return DEFAULT_CUSTOMER;
        }
        return THREAD_CONTEXT.get().customer;
    }

    public static void setCustomer(String customer) {
        if (THREAD_CONTEXT.get() == null) {
            ThreadContext newThreadContext = new ThreadContext();
            newThreadContext.customer = customer;
            THREAD_CONTEXT.set(newThreadContext);
        } else {
            THREAD_CONTEXT.get().customer = customer;
        }
    }

    public static void clearCustomer() {
        if (THREAD_CONTEXT.get() != null) {
            THREAD_CONTEXT.get().customer = null;
        }
    }

}