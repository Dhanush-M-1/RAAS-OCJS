for t in range(int(input())):
    n=int(input())
    a=list(map(int,input().split()))
    a.sort()
    c=a[0]+a[1]
    d=['1','2']
    for i in range(2,len(a)):
        if a[i]>=c:
            d.append(str(i+1))
            break
    if len(d)==2:
        print(-1)
    else:
        print(' '.join(d))
