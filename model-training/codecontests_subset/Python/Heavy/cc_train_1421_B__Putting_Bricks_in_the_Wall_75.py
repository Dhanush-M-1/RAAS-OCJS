for j in range(int(input())):
    n=int(input())
    a=[list(input()) for i in range(n)]
    t=a[0][1]
    r=a[1][0]
    w=a[-1][-2]
    y=a[-2][-1]
    d=[]
    if t==r=='1':
        if w=='1':
            d.append([n,n-1])
        if y=='1':
            d.append([n-1,n])
    elif t==r=='0':
        if w=='0':
            d.append([n,n-1])
        if y=='0':
            d.append([n-1,n])
    elif w==y=='1':
        if t=='1':
            d.append([1,2])
        if r=='1':
            d.append([2,1])
    elif w==y=='0':
        if t=='0':
            d.append([1,2])
        if r=='0':
            d.append([2,1])
    else:
        if w=='1':
            d.append([n,n-1])
        if y=='1':
            d.append([n-1,n])
        if r=='0':
            d.append([2,1])
        if t=='0':
            d.append([1,2])
    print(len(d))
    for x in d:
        print(*x)