def solve(stats):
    for i in range(len(stats)):
        stat = stats[i]
        if stat[1] > stat[0]:
            return "NO"

        if i > 0:
            prev_stat = stats[i - 1]
            diff_plays = stat[0] - prev_stat[0]
            diff_clears = stat[1] - prev_stat[1]

            if diff_plays < 0 or diff_clears < 0 or diff_plays < diff_clears:
                return "NO"

    return "YES"


t = int(input())
for i in range(t):
    n = int(input())
    stats = []
    for j in range(n):
        stats.append(list(map(int, input().split(" "))))

    if len(stats) != n:
        y = "NO"
    else:
        y = solve(stats)

    print(y)
