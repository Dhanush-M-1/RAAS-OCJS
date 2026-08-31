T = int(input())

for t in range(T):
    n = int(input())
    L = list(map(int, input().split()))

    lr = []
    for x in range(len(L)):
        l = 0
        r = 0
        if(L[x] >= n-x-1):
            r = 1
        if(L[x] >= x):
            l = 1
        lr.append((l, r))


    lmax = 0
    rmin = n-1

    index = 0
    while(index < n):
        if(lr[index][0]):
            index += 1
        else:
            index -= 1
            break
    lmax = index

    index = n-1
    while(index >= 0):
        if(lr[index][1]):
            index -= 1
        else:
            index += 1
            break
    rmin = index

    if(lmax >= rmin):
        print("Yes")
    else:
        print("No")
