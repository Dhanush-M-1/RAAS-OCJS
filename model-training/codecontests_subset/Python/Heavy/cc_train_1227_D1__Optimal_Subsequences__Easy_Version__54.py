n=int(input())
a=[int(x) for x in input().split()]
b = [[] for i in range(n + 3)]
for g in range(1, n + 1):
    k = g
    cnt = 0
    mm = 10 ** 10
    m = 0
    for i in range(n):
        if len(b[g]) != 0:
            mm = min(b[g])
        if cnt == k:
            if a[i] > mm:
                for j in range(k - 1, -1, -1):
                    if b[g][j] == mm:
                        b[g].pop(j)
                        break
                b[g].append(a[i])
        else:
            b[g].append(a[i])
            cnt += 1
        m = max(b[g])
m = int(input())
for i in range(m):
    k, pos = [int(x) for x in input().split()]
    pos -= 1
    print(b[k][pos])
