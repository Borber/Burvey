package cn.borber.burvey.service;

import java.util.concurrent.TimeUnit;

/**
 * @author BORBER
 */
public interface IRedisService {
    /**
     * 添加新的键值对
     * @param key 键
     * @param value 值
     */
    void set(String key, Object value);

    /**
     * 设置自动过期键值对
     * @param key 键
     * @param value 值
     * @param timeout 时长
     * @param unit 时间单位
     */
    void set(String key, Object value, long timeout, TimeUnit unit);

    /**
     * 获取对应键的值
     * @param key 键
     * @return 值
     */
    Object get(String key);

    /**
     * 删除对应键的键值对
     * @param key 键
     * @return 删除成功
     */
    boolean delete(String key);
}
