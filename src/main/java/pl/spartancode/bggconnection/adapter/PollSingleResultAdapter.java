package pl.spartancode.bggconnection.adapter;

import pl.spartancode.bggconnection.model.Item;
import pl.spartancode.bggconnection.model.Item.Poll.Result;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class PollSingleResultAdapter extends XmlAdapter<PollSingleResultAdapter.AdaptedPollSingleResult, Result> {


    @Override
    public Result unmarshal(AdaptedPollSingleResult adaptedPollSingleResult) throws Exception {
        if (null == adaptedPollSingleResult) {
            return null;
        }

        if (null != adaptedPollSingleResult.level) {
            Item.Poll.ResultWithLevel result = new Item.Poll.ResultWithLevel();
            result.setLevel(adaptedPollSingleResult.level);
            result.setNumvotes(adaptedPollSingleResult.numvotes);
            result.setValue(adaptedPollSingleResult.value);
            return result;
        } else {
            Result result = new Result();
            result.setNumvotes(adaptedPollSingleResult.numvotes);
            result.setValue(adaptedPollSingleResult.value);
            return result;
        }
    }

    @Override
    public AdaptedPollSingleResult marshal(Result result) throws Exception {
        if (null == result) {
            return null;
        }

        AdaptedPollSingleResult adaptedPollSingleResult = new AdaptedPollSingleResult();
        adaptedPollSingleResult.value = result.getValue();
        adaptedPollSingleResult.numvotes = result.getNumvotes();

        if (result instanceof Item.Poll.ResultWithLevel) {
            adaptedPollSingleResult.level = ((Item.Poll.ResultWithLevel) result).getLevel();
        }
        return adaptedPollSingleResult;
    }

    public static class AdaptedPollSingleResult {
        @XmlAttribute
        public String value;
        @XmlAttribute
        public String numvotes;
        @XmlAttribute
        public String level;
    }
}
