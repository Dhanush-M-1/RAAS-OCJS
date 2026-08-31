import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    enum StepAction {
        LeftUp,
        LeftDown,
        RightUp,
        RightDown,
    }

    public static void main(String[] args) {
        List<Activity> problem = read();
        problem.stream().map(p -> p.count).forEach(System.out::println);
    }

    static List<Activity> read() {
        List<Activity> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            int length = Integer.parseInt(sc.nextLine());
            if (length == 0) {
                break;
            }
            list.add(new Activity(sc.nextLine()));
        }
        return list;
    }

    enum State {
        Down {
            @Override
            public Optional<State> process(StepAction action) {
                switch (action) {
                    case LeftUp:
                        return Optional.of(State.LeftUp);
                    case RightUp:
                        return Optional.of(State.RightUp);
                    default:
                        return Optional.empty();
                }
            }
        },
        LeftUp {
            @Override
            public Optional<State> process(StepAction action) {
                switch (action) {
                    case LeftDown:
                        return Optional.of(State.Down);
                    case RightUp:
                        return Optional.of(State.Up);
                    default:
                        return Optional.empty();
                }
            }
        },
        RightUp {
            @Override
            public Optional<State> process(StepAction action) {
                switch (action) {
                    case RightDown:
                        return Optional.of(State.Down);
                    case LeftUp:
                        return Optional.of(State.Up);
                    default:
                        return Optional.empty();
                }
            }
        },
        Up {
            @Override
            public Optional<State> process(StepAction action) {
                switch (action) {
                    case LeftDown:
                        return Optional.of(State.RightUp);
                    case RightDown:
                        return Optional.of(State.LeftUp);
                    default:
                        return Optional.empty();
                }
            }
        };

        public Optional<State> process(StepAction action) {
            return Optional.empty();
        }
    }

    static class Activity {
        private List<StepAction> list = new ArrayList<>();

        private State state = State.Down;
        private boolean up = false;

        final int count;

        private boolean needCountUp() {
            return up ? state == State.Down : state == State.Up;
        }

        private int count() {
            int n = 0;
            for (StepAction action : list) {
                this.state = this.state.process(action)
                        .orElseThrow(IllegalArgumentException::new);
                if (needCountUp()) {
                    n++;
                    this.up = !this.up;
                }
            }
            return n;
        }

        public Activity(String line) {
            String[] arr = line.split(" ");
            for (String action : arr) {
                switch (action) {
                    case "lu":
                        list.add(StepAction.LeftUp);
                        break;
                    case "ld":
                        list.add(StepAction.LeftDown);
                        break;
                    case "ru":
                        list.add(StepAction.RightUp);
                        break;
                    case "rd":
                        list.add(StepAction.RightDown);
                        break;
                }
            }
            this.count = count();
        }
    }

}

