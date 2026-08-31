N = int(input())
a = []
for i in range(N):
    m = int(input())
    maxmin = 0
    minmax = 0
    for j in range(m):
        x = input()
        x = x.split()
        x = [int(x[0]),int(x[1])]
        if (maxmin == 0) and (minmax == 0):
            maxmin = x[1]
            minmax = x[0]
        else:
            if x[0]>minmax:
                minmax = x[0]
            if x[1]<maxmin:
                maxmin = x[1]
    if minmax - maxmin < 0:
        y = 0
    else:
        y = minmax - maxmin
    a.append(y)
for i in a:
    print(i)
