from collections import defaultdict as dd
for _ in range(int(input())):
    n,m=map(int,input().split(" "))
    lsta=list(map(int,input().split()))
    lstb=list(map(int,input().split()))
    x,y=dd(int),dd(int)
    c=0
    for i in range(n):
        x[lsta[i]]+=1
    for i in range(m):
        y[lstb[i]]+=1
    if n>m:
        for i in range(n):
            if y.get(lsta[i],0)!=0:
                c+=1
                print("YES")
                print("1",lsta[i])
                break
    else:
        for i in range(m):
            if x.get(lstb[i],0)!=0:
                c+=1
                print("YES")
                print("1",lstb[i])
                break
    if c==0:
        print("NO")