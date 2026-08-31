import sys
input = sys.stdin.readline


t = int(input())
for _ in range(t):
    n = int(input())
    s = [list(map(int, input().split())) for _ in range(n)]
    prev = s[0]
    res = "YES"

    if prev[0] < prev[1]:
        print("NO")
        continue

    for i in range(1, n):
        curr = s[i]
        if prev[0] > curr[0]:
            res = "NO"
            break
        if prev[1] > curr[1]:
            res = "NO"
            break
        if curr[0]-prev[0] < curr[1]-prev[1]:
            res = "NO"
            break
        if curr[0] < curr[1]:
            res = "NO"
            break

        prev = curr

    print(res)