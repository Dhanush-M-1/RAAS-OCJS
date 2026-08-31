z = int(input())
for zz in range(z):
    n = int(input())
    a = [int(i) for i in input().split()]
    mG = a[0]
    mS = -1
    mB = -1
    g = 1
    s = 0
    b = 0

    i = 1
    while i < n:
        if a[i] == mG:
            g += 1
        else:
            mS = a[i]
            break
        i += 1

    while i < n:
        if a[i] == mS:
            s += 1
        else:
            if s <= g:
                mS = a[i]
                s += 1
            else:
                mB = a[i]
                break
        i += 1
    sI = i
    pI = i
    while i < n:
        if a[i] != mB:
            if i > n // 2:
                break
            else:
                pI = i - 1
                mB = a[i]
        i += 1
        
    b = pI - sI + 1
    if (s > g and b > g) and g + s + b <= n // 2:
        print(g, s, b)
    else:
        print(0, 0, 0)
