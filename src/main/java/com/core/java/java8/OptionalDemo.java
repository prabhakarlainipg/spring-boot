package com.core.java.java8;

import lombok.Getter;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) throws Exception {
        Optional<String> name = Optional.ofNullable(null);
        System.out.println(name.orElse("NA"));
        System.out.println(name.orElseGet(()->"NONE"));

       /* Optional<String> result =
                Optional.of(null); ////NPE*/


      //  System.out.println(result.get()); //Not Reachable

        Optional<String> result1 =
                Optional.ofNullable(null);


       // System.out.println(result1.get()); //NoSuchElementException




        //without optional
        Book book = getBook();

        String summaryText = null;

        if(book != null) {

            Chapter chapter = book.getChapter();

            if(chapter != null) {

                Summary summary = chapter.getSummary();

                if(summary != null) {

                    summaryText =
                            summary.getText();
                }
            }
        }

        System.out.println(summaryText);


        String summary =
                Optional.of(book)
                        .flatMap(Book::getChapterOptional)
                        .flatMap(Chapter::getSummaryOptional)
                        .map(Summary::getText)
                        //.orElse(getDefault());
         .orElseGet(OptionalDemo::getDefault);



        System.out.println(summary);
    }

    private static String getDefault() {
        System.out.println("Executing getDefault");
        return "Default";
    }

    private static Book getBook() {
        return new Book(new Chapter(new Summary("MySummary")));
    }
}

class Book {

    private Chapter chapter;

    public Book(Chapter chapter) {
        this.chapter = chapter;
    }

    public Chapter getChapter() {
        return null;
    }

    public Optional<Chapter> getChapterOptional() {
        return Optional.ofNullable(chapter);
    }
}

@Getter
class Chapter {

    private Summary summary;

    public Chapter(Summary summary) {
        this.summary = summary;
    }

    public Optional<Summary> getSummaryOptional() {
        return Optional.ofNullable(summary);
    }
}

class Summary {
    private String text;

    public Summary(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
