t = input()
t = int(t)
while t:
    t -= 1
    n = input()
    a = input()
    a = [int(str) for str in a.split()]
    #print('a = {}'.format(a))
    minn = 1e10
    dist = -1
    maxx = -1
    for i in range(len(a)):
        cur = a[i]
        if cur == -1:
            if i == 0:
                if a[i+1] != -1:
                    minn = min(a[i+1], minn)
                    maxx = max(a[i+1], maxx)
            elif i == len(a) - 1:
                if a[i-1] != -1:
                    minn = min(a[i-1], minn)
                    maxx = max(a[i-1], maxx)
            else:
                if a[i+1] != -1:
                    minn = min(a[i+1], minn)
                    maxx = max(a[i+1], maxx)
                if a[i-1] != -1:
                    minn = min(a[i-1], minn)
                    maxx = max(a[i-1], maxx)
        else:
            if i != 0 and a[i - 1] != -1:
                dist = max(dist, abs(a[i] - a[i-1]))
    if maxx == -1:
        maxx = minn = 0
    k = (maxx + minn) // 2
    dist = max(dist, abs(k - maxx))
    #print('dist = {}, k = {}, maxx = {}, minn = {}'.format(dist, k, maxx, minn))
    print(dist, k)