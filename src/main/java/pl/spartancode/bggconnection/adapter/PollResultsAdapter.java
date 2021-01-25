package pl.spartancode.bggconnection.adapter;


import pl.spartancode.bggconnection.model.Item;
import pl.spartancode.bggconnection.model.Item.Poll.Results;
import pl.spartancode.bggconnection.model.Item.Poll.ResultsSuggestedNumplayers;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class PollResultsAdapter extends XmlAdapter<PollResultsAdapter.AdaptedPollResults, Results> {

    @Override
    public Results unmarshal(AdaptedPollResults adaptedPollResults) throws Exception {
        if (null == adaptedPollResults) {
            return null;
        }

        if (null != adaptedPollResults.numplayers) {
            ResultsSuggestedNumplayers results = new ResultsSuggestedNumplayers();
            results.setNumplayers(adaptedPollResults.numplayers);
            results.setResult(adaptedPollResults.result);
            return results;
        } else {
            Results results = new Results();
            results.setResult(adaptedPollResults.result);
            return results;
        }
    }

    @Override
    public AdaptedPollResults marshal(Results results) throws Exception {
        if (null == results) {
            return null;
        }

        AdaptedPollResults adaptedPollResults = new AdaptedPollResults();
        adaptedPollResults.result = results.getResult();
        if (results instanceof ResultsSuggestedNumplayers) {
            adaptedPollResults.numplayers = ((ResultsSuggestedNumplayers) results).getNumplayers();
        }

        return adaptedPollResults;
    }

    public static class AdaptedPollResults {
        public Item.Poll.Result[] result;
        @XmlAttribute
        public String numplayers;
    }
}
