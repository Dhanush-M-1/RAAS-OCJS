read = lambda: map(int, input().split())
a, b = input().split()
n = int(input())
ans = [list() for i in range(n + 1)]
ans[0] = a, b
for i in range(1, n + 1):
    a, b = input().split()
    if ans[i - 1][0] == a:
        ans[i] = ans[i - 1][1], b
    else:
        ans[i] = ans[i - 1][0], b
for i in range(n + 1):
    print(*ans[i])