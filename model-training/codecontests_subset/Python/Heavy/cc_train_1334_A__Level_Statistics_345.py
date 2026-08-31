# Problem URL: https://codeforces.com/contest/1334/problem/0


def solve(n, stats):
    p = 0
    c = 0
    for stat in stats:
        if stat[0] < p or stat[1] < c or stat[1] - c > stat[0] - p:
            return False
        p = stat[0]
        c = stat[1]
    return True


t = int(input())

for _ in range(t):
    n = int(input())
    stats = []
    for i in range(n):
        current_stat = list(map(int, input().split()))
        stats.append(current_stat)
    if solve(n, stats):
        print("YES")
    else:
        print("NO")
