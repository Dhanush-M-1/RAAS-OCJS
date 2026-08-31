from sys import stdin
input = stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    a = [list(input().rstrip()) for _ in range(n)]
    ans = []
    if a[0][1] == a[1][0]:
        if a[-1][-2] == a[0][1]:
            ans.append((n, n-1))
        if a[-2][-1] == a[0][1]:
            ans.append((n-1, n))
    elif a[-1][-2] == a[-2][-1]:
        if a[0][1] == a[-1][-2]:
            ans.append((1, 2))
        if a[1][0] == a[-1][-2]:
            ans.append((2, 1))
    else:
        if a[0][1] == "1":
            ans.append((1, 2))
        if a[1][0] == "1":
            ans.append((2, 1))
        if a[-1][-2] == "0":
            ans.append((n, n-1))
        if a[-2][-1] == "0":
            ans.append((n-1, n))
    print(len(ans))
    for i in ans:
        print(*i)