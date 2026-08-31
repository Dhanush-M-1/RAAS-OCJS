while 1:
    n = int(input())
    if n == 0:
        break

    alist = []
    for _ in range(n):
        a = int(input())
        alist.append(a)

    cnt = 0
    for i in range(len(alist)):
        for j in range(len(alist)-1, i, -1):
            if alist[j] < alist[j-1]:
                alist[j], alist[j-1] = alist[j-1], alist[j]
                cnt += 1

    print(cnt)

