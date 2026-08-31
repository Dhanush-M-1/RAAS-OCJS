for _ in range(int(input())):
    n=int(input())
    a=[int(o) for o in input().split()]
    g,s,b=0,0,0
    mg,ms,mb=float('inf'),float('inf'),float('inf')
    i=0
    while i<n//2:
        if g==0:
            g+=1
            mg=min(mg,a[i])
        elif a[i]==mg:
            g+=1
        elif s<=g:
            s+=1
            ms=min(ms,a[i])
        elif a[i]==ms:
            s+=1
        else:
            mb=min(mb,a[i])
            b+=1
        i+=1
    while i>=0:
        if a[i]==a[i-1]:
            b-=1
            mb=max(mb,a[i-1])
        else:
            break
        i-=1
    if(g<b and g<s)and (mg>ms>mb):
        print(g,s,b)
    else:
       # print(g,s,b)
        print(0,0,0)
            