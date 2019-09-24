layui.define(['layer','form','table'],function (exports) {
    var table = layui.table;
    table.render({
        elem: '#demo',
        height: 312,
        url: '/query', //数据接口
        page: true, //开启分页
        cols: [[ //表头
            {field: 'rank', title: '排名', width:80, sort: true}
            ,{field: 'title', title: '视频标题', width:160}
            ,{field: 'videoUrl', title: '视频链接', width:160}
            ,{field: 'play', title: '播放', width:100,sort: true}
            ,{field: 'danmaku', title: '弹幕', width: 100,sort: true}
            ,{field: 'author', title: '作者', width: 80}
            ,{field: 'authorUrl', title: '个人空间', width: 160}
            ,{field: 'score', title: '评分', width: 100,sort: true}
        ]]
    });
    exports('index', {});
});