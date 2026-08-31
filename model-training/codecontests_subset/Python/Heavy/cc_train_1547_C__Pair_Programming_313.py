t = int(input())

for p in range(t):
    bull = input()
    l = list(map(int, input().rstrip().split()))
    k = l[0]
    n = l[1]
    m = l[2]
    l1 = list(map(int, input().rstrip().split()))
    l2 = list(map(int, input().rstrip().split()))
    f = 1
    x = max(l1)
    y = max(l2)
    z = max(x, y)
    z1 = l1.count(0)
    z2 = l2.count(0)
    res = []
    if z > z1 + z2 + k:
        f = 0
    else:
        i = 0
        j = 0
        while i < n and j < m:
            if l1[i] <= l2[j]:
                res.append(l1[i])
                i += 1
            else:
                res.append(l2[j])
                j += 1
        if i < n:
            for h in range(i, n):
                res.append(l1[h])
        elif j < m:
            for q in range(j, m):
                res.append(l2[q])
        sum = k
        for b in range(len(res)):
            if res[b] == 0:
                sum += 1
            else:
                if res[b] > sum:
                    f = 0
    if f == 1:
        for v in range(len(res)):
            print(res[v], end=' ')
    else:
        print(-1)
    # print(i)
    # print(j)
    print("\n")



