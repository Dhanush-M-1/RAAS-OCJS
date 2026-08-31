
def want(num):

    L = 0
    R = 10 ** 9

    for i in range(n-1):

        if a[i] != -1 and a[i+1] != -1:
            if abs(a[i] - a[i+1]) > num:
                return -1

        elif a[i] == -1 and a[i+1] != -1:

            L = max(L , a[i+1] - num)
            R = min(R , a[i+1] + num)

            if L > a[i+1] + num or R < a[i+1] - num:
                return -1

        elif a[i] != -1 and a[i+1] == -1:

            L = max(L , a[i] - num)
            R = min(R , a[i] + num)

            if L > a[i] + num or R < a[i] - num:
                return -1

        if L > R:
            return -1

    return L


t = int(input())
nans = 0 

for loop in range(t):

    n = int(input())

    a = list(map(int,input().split()))

    l = -1
    r = 10 ** 9

    while r - l != 1:

        m = (r+l) // 2

        ret = want(m)
        #print (m,ret)

        if ret < 0:
            l = m
        else:
            r = m
            nans = ret

    print (r,nans)