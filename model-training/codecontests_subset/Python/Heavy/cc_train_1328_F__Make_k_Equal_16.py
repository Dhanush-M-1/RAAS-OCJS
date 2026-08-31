from sys import stdin

inp = stdin.readline

n, k= [int(x) for x in inp().strip().split()]

a = [int(x) for x in inp().strip().split()]

a.sort()

d = {}

ans = -1
for i in a:
    j = 0
    while i != 0:
        if d.get(i,0) == 0:
            d[i] = [1, j]
        else:
            if d[i][0] < k:
                d[i][0] += 1
                d[i][1] += j
        if d[i][0] == k:
            if ans == -1:
                ans = d[i][1]
                break
            else:
                ans = min(ans, d[i][1])
                break
        i //= 2
        j += 1
print(ans)