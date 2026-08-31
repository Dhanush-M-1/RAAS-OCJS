for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    if n == 1:
        print(0, 0, 0)
        continue
    lim = a[n//2]
    a = a[:n//2]
    n = len(a)
    ind = 0
    g, s, b = 0, 0, 0
    while ind < len(a):
        if a[ind] == a[0]:
            g+=1
        else:
            break
        ind+=1
    if 3*g+2 > len(a):
        print(0, 0, 0)
        continue
    s+=g
    ind+=g
    sb = ind
    while ind < len(a):
        if a[ind] == a[sb]:
            s+=1
        else:
            break
        ind+=1
    if len(a) - g - s <= g:
        print(0, 0, 0)
        continue
    while ind < len(a):
        if a[ind] != lim:
            b+=1
            ind+=1
        else:
            break
    if g < s and g < b:
        print(g, s, b)
    else:
        print(0, 0, 0)