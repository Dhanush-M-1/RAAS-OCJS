def restore_history(initial_line_count, seq_a, seq_b):
    history = []

    cursors = [0, 0]
    current_cursor_index = 0

    switch_count = 0

    line_count = initial_line_count

    while len(history) < len(seq_a) + len(seq_b):
        seq = seq_a if current_cursor_index == 0 else seq_b

        if cursors[current_cursor_index] < len(seq):
            action = seq[cursors[current_cursor_index]]

            if action == 0 or action <= line_count:
                history.append(str(action))
                cursors[current_cursor_index] += 1

                if action == 0:
                    line_count += 1

                switch_count = 0

            else:
                current_cursor_index = (current_cursor_index + 1) % 2
                switch_count += 1

        else:
            current_cursor_index = (current_cursor_index + 1) % 2
            switch_count += 1

        if switch_count > 1:
            return []

    return history

T = int(input())

import sys

while T:
    sys.stdin.readline()
    k, n, m = list(map(int, sys.stdin.readline().split()))

    seq_a = list(map(int, sys.stdin.readline().split()))
    seq_b = list(map(int, sys.stdin.readline().split()))

    history = restore_history(k, seq_a, seq_b)

    if history:
        print(' '.join(history))
    else:
        print(-1)

    T -= 1
