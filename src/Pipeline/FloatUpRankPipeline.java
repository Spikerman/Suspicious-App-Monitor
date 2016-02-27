package Pipeline;

import BasicData.AppData;
import Controller.AppInfoController;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by chenhao on 2/7/16.
 */
public class FloatUpRankPipeline implements Pipeline {

    AppInfoController appInfoController;

    public FloatUpRankPipeline(AppInfoController appInfoController) {
        this.appInfoController = appInfoController;
    }

    public AppInfoController getAppInfoController() {
        return appInfoController;
    }

    public void setAppInfoController(AppInfoController appInfoController) {
        this.appInfoController = appInfoController;
    }

    @Override
    public void process(ResultItems resultItems, Task task) {

        List appIdList = resultItems.get("upIdList");
        int size = resultItems.get("size");
        List<AppData> appDataList = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            appDataList.add(new AppData(appIdList.get(i).toString(), i + 1, AppData.topFlowUp));
        }
        appInfoController.appendAppIdList(appIdList);
        appInfoController.appendAppDataList(appDataList);
    }
}
