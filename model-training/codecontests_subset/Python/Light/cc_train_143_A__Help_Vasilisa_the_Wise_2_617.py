def readln(): return tuple(map(int, input().split()))

r = readln()
c = readln()
d = readln()
ans = [-1, -1, -1, -1]
for i in range(1, 10):
    for j in range(1, 10):
        for k in range(1, 10):
            for m in range(1, 10):
                if len(set([i, j, k, m])) == 4 and r == (i + j, k + m) and c == (i + k, j + m) and d == (i + m, j + k):
                    ans = [i, j, k, m]
if ans[0] == -1:
    print(-1)
else:
    print(ans[0], ans[1])
    print(ans[2], ans[3])
