for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    temp = []
    minm = 10**9 + 1
    maxm = -10**9 -1
    for i in range(n):
        if a[i] != -1:
            if i == 0:
                if a[1] == -1 :
                    temp.append(a[i])
            elif i == n-1:
                if a[i-1] == -1:
                    temp.append(a[i])
            else:
                if a[i-1] == -1 or a[i+1] == -1:
                    temp.append(a[i])
    if len(temp) != 0:
        maxm = max(temp)
        minm = min(temp)
    k = (maxm + minm)//2
    for i in range(n):
        if a[i] == -1:
            a[i] = k
    m = -10
    for i in range(1,n):
        m = max(m, abs(a[i] - a[i-1]))
    print(m, k)
