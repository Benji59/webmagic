package us.codecraft.webmagic.proxy;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Task;

/**
 * Proxy provider. <br>
 *     
 * @since 0.7.0
 */
public interface ProxyProvider {

    /**
     *
     * Return proxy to Provider when complete a download.
     * @param proxy the proxy config contains host,port and identify info
     * @param page the download result
     * @param task the download task
     */
    void returnProxy(Proxy proxy, Page page, Task task);

    /**
     *  代理IP是珍贵资源，有可能代理提供者内部代理没有过期，就一直提供某个IP，但这个IP又不可以使用，所以提供一种方式通知提供者，这个代理该刷新了
     *
     * @param task  下载任务
     * @param proxy 需要对代理进行验证，如果确实持有的时错误代理，则刷新，否则，继续执行
     */
    void refreshProxy(Task task,Proxy proxy);


    /**
     *
     * 获取当前正在提供的代理
     *
     * @param task
     * @return
     */
    Proxy getCurrentProxy(Task task);

    /**
     * Get a proxy for task by some strategy.
     * @param task the download task
     * @return proxy 
     */
    Proxy getProxy(Task task);

}
