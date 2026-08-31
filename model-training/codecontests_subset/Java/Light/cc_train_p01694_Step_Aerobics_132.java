import java.util.Scanner;


public class Main {
	public static void main(String args[]) {
		new Main().run();
	}	

	void run() {
		Scanner sc = new Scanner(System.in);

		for (;;) {
			int n = sc.nextInt();
			if (n == 0) {
				break;
			}
			String[] operations = new String[n];
			for (int i = 0; i < n; i++) {
				operations[i] = sc.next();
			}
			System.out.println(solve(n, operations));
		}

	}

	int solve(int n, String[] operations) {

		State currentState = State.MovingUp_LeftDownRightDown;

		int res = 0;
		for (String str : operations) {
			Command c = Command.valueOf(str);
			StateAndOutput next = getNext(currentState,c);

			res += next.i;
			currentState = next.s;
		}
		return res;
	}

	enum State {
		MovingUp_LeftDownRightDown, MovingUp_LeftDownRightUp, MovingUp_LeftUpRightDown, MovingDown_LeftUpRightUp, MovingDown_LeftUpRightDown, MovingDown_LeftDownRightUp,
	}

	enum Command {
		lu, ru, ld, rd
	}

	static class StateAndOutput {
		State s;
		int i;

		StateAndOutput(State s, int i) {
			this.s = s;
			this.i = i;
		}
	}

	static StateAndOutput getNext(State currentState, Command command) {
		switch (currentState) {
		case MovingUp_LeftDownRightDown:
			switch (command) {
			case lu:
				return new StateAndOutput(State.MovingUp_LeftUpRightDown, 0);
			case ru:
				return new StateAndOutput(State.MovingUp_LeftDownRightUp, 0);
			}
		case MovingUp_LeftDownRightUp:
			switch (command) {
			case lu:
				return new StateAndOutput(State.MovingDown_LeftUpRightUp, 1);
			case rd:
				return new StateAndOutput(State.MovingUp_LeftDownRightDown,0);
			}
		case MovingUp_LeftUpRightDown:
			switch (command) {
			case ru:
				return new StateAndOutput(State.MovingDown_LeftUpRightUp, 1);
			case ld:
				return new StateAndOutput(State.MovingUp_LeftDownRightDown,0);
			}
		case MovingDown_LeftUpRightUp:
			switch (command) {
			case ld:
				return new StateAndOutput(State.MovingDown_LeftDownRightUp, 0);
			case rd:
				return new StateAndOutput(State.MovingDown_LeftUpRightDown, 0);
			}
		case MovingDown_LeftUpRightDown:
			switch (command) {
			case ru:
				return new StateAndOutput(State.MovingDown_LeftUpRightUp, 0);
			case ld:
				return new StateAndOutput(State.MovingUp_LeftDownRightDown,1);
			}
		case MovingDown_LeftDownRightUp:
			switch (command) {
			case lu:
				return new StateAndOutput(State.MovingDown_LeftUpRightUp, 0);
			case rd:
				return new StateAndOutput(State.MovingUp_LeftDownRightDown,1);
			}
		}
		throw new RuntimeException("??¶?´???????????°??????????");
	}
}