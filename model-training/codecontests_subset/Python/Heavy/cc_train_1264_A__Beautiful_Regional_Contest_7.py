from collections import defaultdict
t=int(input())
for _ in range(t):
    n=int(input())
    aa=list(map(int,input().split()))
    d=defaultdict(int)
    for i in aa:
        d[i] +=1
    a=[]
    for i in d:
        a.append((i,d[i]))
    a=sorted(a,reverse=True)
    if len(a)<3:
        print(0,0,0)
    else:
        g,s,b=0,0,0
        cnt=0
        c=0
        while cnt <= n//2:
            cnt += a[c][1] 
            if cnt <= n//2:
                c+=1
            else:
                cnt -= a[c][1]
                c -= 1
                break
        if c==len(a) or c==-1:
            print(0,0,0)
        else:
            if cnt > n//2:
                cnt -=a[c][1]
                c -= 1
            if c<2:
                print(0,0,0)
            else:
                i=1
                g=a[0][1]
                s=0
                while i<=c and s<=g:
                    s += a[i][1]
                    i += 1
                b=0
                if i==c+1:
                    print(0,0,0)
                else:
                    while i<=c:
                        b += a[i][1]
                        i += 1
                    if b<=g or s<=g:
                        print(0,0,0)
                    else:
                        print(g,s,b)