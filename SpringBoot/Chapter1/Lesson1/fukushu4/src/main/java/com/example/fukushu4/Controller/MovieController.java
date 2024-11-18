package com.example.fukushu4.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/movie")
@RestController
public class MovieController {
    @RequestMapping("")
    public String movie(){
        return "映画一覧ページ"

        +"<a href='/movie/newer'>最新映画一覧</a>"
        +"<a href='/movie/search/0'>映画検索画面</a>";
    }
    @RequestMapping("/newer")
    public String newer(){
        return "最新映画一覧ページ"
        +"<a href='/movie'>映画一覧</a>"
        +"<a href='/movie/search/0'>映画検索画面</a>";
    }
    @RequestMapping("/search/{num}")
        public String search(@PathVariable("num")int num){
            return "映画"+num+"の情報"
            +"<a href='/movie'>映画一覧</a>"
            +"<a href='/movie/newer'>最新映画一覧</a>";
    }

}
