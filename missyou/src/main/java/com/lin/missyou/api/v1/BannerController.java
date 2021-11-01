package com.lin.missyou.api.v1;

import com.lin.missyou.core.interceptors.ScopeLevel;
import com.lin.missyou.exception.Http.NotFoundException;
import com.lin.missyou.service.BannerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.lin.missyou.model.Banner;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/banner")
@Validated
public class BannerController {

    private final BannerService bannerService;
    private final Integer cycleDate = 5;
    private final String URL = "/url";

    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @GetMapping("/name/{name}")
    @ScopeLevel()
    public Banner getByName(@PathVariable String name) {
        Banner banner = bannerService.getByName(name);
        if (banner == null) {
            throw new NotFoundException(30005);
        }
        return banner;
    }


    @GetMapping("/test/date2")
    public List<String> getDateRange2() {
        return this.getRangeDate2();
    }

    public List<String> getRangeDate2 () {
        List<String> stringList2 = new ArrayList<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int earliestDate = 1996;
        int dateRange = currentYear - earliestDate;
        for (int i = 0; i < dateRange; i++) {
            stringList2.add(this.getPreviousYear(i));
        }
        Collections.sort(stringList2);
        return this.testChange(stringList2);
    }

    public List<String> testChange(List<String> stringList2) {
        List<String> listChange = new ArrayList<>();
        for (int i = 0; i < stringList2.size(); i++) {
            if(i == stringList2.size() -1) {
                break;
            }
            String t2 = stringList2.get(i+1);
            String t1 = stringList2.get(i);

            if (t1 != null) {
                listChange.add(this.URL + "?" + "t1=" + t1 + "&" + "t2=" + t2);
            }
        }
        return listChange;
    }


    @GetMapping("/test/date")
    public List<List<String>> getDateRange() {
        return this.getRangeDate();
    }
    @GetMapping("/date/list")
    public List<String> dateStringList() {
        List<List<String>> lists = this.getDateRange();
        List<String> stringList = new ArrayList<>();
        for (List<String> list : lists) {
            if (list.size() == 1) {
                return stringList;
            } else {
                String t2 = list.get(0);
                String t1 = list.get(1);
                stringList.add(this.URL + "?" + "t1=" + t1 + "&" + "t2=" + t2);
            }
        }
        return stringList;
    }

    public String getPreviousYear(Integer number) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.YEAR, Integer.parseInt("-" + number));
        Date y = calendar.getTime();
        return simpleDateFormat.format(y);
    }

    public List<List<String>> getRangeDate() {
        List<String> stringList = new ArrayList<>();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int earliestDate = 1996;
        int dateRange = currentYear - earliestDate;
        for (int i = 0; i < dateRange; i++) {
            stringList.add(this.getPreviousYear(i));
        }
        // Collections.sort(stringList);
        return this.getSplitList(2,stringList);
    }
    public <T> List<List<T>> getSplitList(int splitNum, List<T> list) {
        List<List<T>> splitList = new LinkedList<>();
        int groupFlag = list.size() % splitNum == 0 ? (list.size() / splitNum) : (list.size() / splitNum + 1);
        for (int j = 1; j <= groupFlag; j++) {
            if ((j * splitNum) <= list.size()) {
                splitList.add(list.subList(j * splitNum - splitNum, j * splitNum));
            } else if ((j * splitNum) > list.size()) {
                splitList.add(list.subList(j * splitNum - splitNum, list.size()));
            }
        }
        return splitList;
    }

}
