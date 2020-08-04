
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class ConditionMessageMap {
    private static final Map<Condition, Message> messageMap;

    static {
        messageMap = new LinkedHashMap<>();
        messageMap.put(new Condition(0, 10), new Message("Очень быстро"));
        messageMap.put(new Condition(10, 100), new Message("Быстро"));
        messageMap.put(new Condition(100, 500), new Message("Медленно"));
        messageMap.put(new Condition(500, Long.MAX_VALUE), new Message("Придется подождать"));
    }

    public static Optional<Message> getMessageByTime(long time) {
        Optional<Map.Entry<Condition, Message>> messageEntry = messageMap.entrySet().stream()
                .filter(conditionMessageEntry -> conditionMessageEntry.getKey().match(time))
                .findFirst();
        return messageEntry.map(Map.Entry::getValue);
    }


}
