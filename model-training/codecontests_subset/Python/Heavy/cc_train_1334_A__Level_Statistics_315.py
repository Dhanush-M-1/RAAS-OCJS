n_tests = int(input())

for _ in range(n_tests):
    n_times = int(input())
    last_n_play = 0
    last_n_cleared = 0
    last_n_fails = 0
    possible = True
    for t in range(n_times):
        n_play, n_cleared = list(map(int, input().split()))
        if not possible:
            continue
        n_fails = n_play - n_cleared
        if n_play < last_n_play:
            possible = False
        elif n_cleared < last_n_cleared:
            possible = False
        elif n_fails < last_n_fails:
            possible = False
        last_n_play = n_play
        last_n_cleared = n_cleared
        last_n_fails = n_fails
    if not possible:
        print("NO")
    else:
        print("YES")
