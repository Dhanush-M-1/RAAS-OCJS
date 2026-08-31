def check_pair(stats1, stats2):
    plays1, clears1 = stats1
    plays2, clears2 = stats2

    diff_plays = plays2 - plays1
    diff_clears = clears2 - clears1
    if 0 <= diff_clears <= diff_plays:
        return 1
    return 0


t = int(input())
for _ in range(t):
    correct = True
    stats = [(0,0)]
    n = int(input())
    for _ in range(n):
        plays, clears = [int(i) for i in input().split()]
        stats.append((plays, clears))
    for i in range(n):
        if not check_pair(stats[i], stats[i+1]):
            print('NO')
            correct = False
            break
    if correct:
        print('YES')

