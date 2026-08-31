from sys import stdin


def inp():
    return next(ss.rstrip() for ss in stdin)


def itg():
    return int(inp())


def mpint():
    return map(int, inp().split())

# O(26) = O(1) !!!

for case in range(itg()):
    n, m = mpint()
    s = inp()
    data = [[0]*26]
    for i in range(n):
        data[i][ord(s[i]) - 97] += 1
        data.append(data[i].copy())
    pp = (int(i) - 1 for i in inp().split())
    ans = data[-1]
    for p in pp:
        for i in range(26):
            ans[i] += data[p][i]

    print(*ans)
