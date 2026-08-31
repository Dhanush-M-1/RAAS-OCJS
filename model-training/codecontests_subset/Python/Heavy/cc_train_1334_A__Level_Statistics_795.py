t=int(input())
for _ in range(t):
    n=int(input())
    ps,cs=[0],[0]
    for i in range(n):
        p,c=map(int,input().split())
        ps,cs=ps+[p],cs+[c]
    z=1
    for i in range(1,n+1):
        if ps[i]>=cs[i]:
            if ps[i]-ps[i-1]>=cs[i]-cs[i-1] and ps[i]-ps[i-1]>=0 and cs[i]-cs[i-1]>=0:
                continue
            else:
                #print(_,i,1)
                z=0
                print("NO")
                break
        else:
            #print(_,i,2)
            z=0
            print("NO")
            break
    if z:
        print('YES')
