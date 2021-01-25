package pl.spartancode.bggconnection.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.spartancode.bggconnection.adapter.PollResultsAdapter;
import pl.spartancode.bggconnection.adapter.PollSingleResultAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@Data
@NoArgsConstructor
@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item {
    private String thumbnail;
    private String image;
    private Name[] name;
    private String description;
    private SingleValue yearpublished;
    private SingleValue minplayers;
    private SingleValue maxplayers;
    private Poll[] poll;
    private SingleValue playingtime;
    private SingleValue minplaytime;
    private SingleValue maxplaytime;
    private SingleValue minage;
    private Link[] link;
    @XmlAttribute
    private String type;
    @XmlAttribute
    private String id;

    @Data
    @NoArgsConstructor
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class SingleValue {
        @XmlAttribute
        private String value;
    }

    @Data
    @NoArgsConstructor
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Name {
        @XmlAttribute
        private String type;
        @XmlAttribute
        private String sortindex;
        @XmlAttribute
        private String value;
    }

    @Data
    @NoArgsConstructor
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Poll {
        @XmlAttribute
        private String name;
        @XmlAttribute
        private String title;
        @XmlAttribute
        private String totalvotes;
        private Results[] results;

        @Data
        @NoArgsConstructor
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlJavaTypeAdapter(PollResultsAdapter.class)
        @XmlRootElement(name = "results")
        public static class Results {
            private Result[] result;
        }

        @EqualsAndHashCode(callSuper = true)
        @Data
        @NoArgsConstructor
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlRootElement(name = "results")
        public static class ResultsSuggestedNumplayers extends Results {
            @XmlAttribute
            private String numplayers;

        }

        @Data
        @NoArgsConstructor
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlRootElement(name = "result")
        @XmlJavaTypeAdapter(PollSingleResultAdapter.class)
        public static class Result {
            @XmlAttribute
            private String value;
            @XmlAttribute
            private String numvotes;
        }

        @EqualsAndHashCode(callSuper = true)
        @Data
        @NoArgsConstructor
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlRootElement(name = "result")
        public static class ResultWithLevel extends Result {
            @XmlAttribute
            private String level;
        }
    }

    @Data
    @NoArgsConstructor
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Link {
        @XmlAttribute
        private String type;
        @XmlAttribute
        private String id;
        @XmlAttribute
        private String value;
    }
}

