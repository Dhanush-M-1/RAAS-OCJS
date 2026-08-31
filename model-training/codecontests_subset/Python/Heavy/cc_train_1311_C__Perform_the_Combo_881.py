from sys import stdin

def inp():
    return stdin.readline().strip()

t = int(inp())
for _ in range(t):
    n, m = [int(x) for x in inp().split()]
    s = inp()
    p = [int(x) for x in inp().split()]
    pressed = [0]*n
    for i in range(len(p)):
        pressed[p[i]-1]+=1
    for i in range(n-1, 0, -1):
        pressed[i-1] += pressed[i]
    ans = [0]*26
    for i in range(n):
        asc = ord(s[i])
        ans[asc-97]+=pressed[i]
    for i in range(n):
        asc = ord(s[i])
        ans[asc-97]+=1
    print(*ans)