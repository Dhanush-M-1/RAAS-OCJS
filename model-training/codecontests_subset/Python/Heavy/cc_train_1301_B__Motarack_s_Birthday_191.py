t = int(input())
for z in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    ma = 0
    mi = 10**9
    maM = 0
    i = 0
    j = 1
    f = 0
    while j < n:
        if a[j] == -1 and a[i] != -1:
            f = 1
            if a[i] > ma:
                ma = a[i]
            if a[i] < mi:
                mi = a[i]
        if a[i] == -1 and a[j] != -1:
            f = 1
            if a[j] > ma:
                ma = a[j]
            if a[j] < mi:
                mi = a[j]
        if a[i] != -1 and a[j] != -1:
            if abs(a[i] - a[j]) > maM:
                maM = abs(a[i] - a[j])
        i+=1
        j+=1
    k = (ma + mi)//2
    m1 = max(abs(ma - k), abs(mi - k))
    m = max(m1, maM)
    if f == 0 and maM == 0:
        print(0, k)
    else:
        print(m, k)