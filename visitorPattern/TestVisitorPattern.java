package DESIGNPATTERNS.visitorPattern;

enum State {
    PENDING{
        public <T> T accept(StateVisitor<T> visitor){
            return visitor.pendingVisitor();
        };
    },
    COMPLETED{
        public <T> T accept(StateVisitor<T> visitor){
            return visitor.completedVisitor();
        };
    },
    REJECTED{
        public <T> T accept(StateVisitor<T> visitor){
            return visitor.rejecetdVisitor();
        };
    };

    private State(){
    }

    public abstract <T> T accept(StateVisitor<T> var1);

    public abstract static class StateVisitor<T>{
        public T pendingVisitor(){
            return null;
        }
        public T completedVisitor(){
            return null;
        }
        public T rejecetdVisitor(){
            return null;
        }
    }
}

public class TestVisitorPattern{
    public static void main(String[] args){
        final var state= State.COMPLETED; //could be anything from transactional DB

        state.accept(new State.StateVisitor<>(){
            @Override
            public Boolean pendingVisitor(){
                System.out.println("Here pendingVisitor");
                return true; //I define login and return type on demand
            };

            @Override
            public Integer completedVisitor(){
                System.out.println("Here completedVisitor");
                return 2; //I define login and return type on demand
            };

            @Override
            public String rejecetdVisitor(){
                System.out.println("Here rejecetdVisitor");
                return "Yoo"; //I define login and return type on demand
            };
        });
    }
}
