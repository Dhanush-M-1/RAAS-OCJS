import sys
input = sys.stdin.buffer.readline

t = int(input())
for _ in range(t):
    n, l, r = map(int, input().split())

    s = 1
    while l > (n-s)*2:
        if s == n:
            break

        l -= (n-s)*2
        r -= (n-s)*2
        s += 1

    #print(s, l, r)

    ans = []
    while len(ans) <= r:
        if s == n:
            ans.append(1)
            break
        for j in range(s+1, n+1):
            ans.append(s)
            ans.append(j)
        s += 1
    print(*ans[l-1:r])
