n,m=map(int,input().split())

alist=[]
sumlist=[]
for i in range(n):
    a=list(input().split())
    del a[0]    # number 0 is swithch 
    sumlist=sumlist+a
    alist.append(a)

if len(set(sumlist))==m:
    print("YES")
else:
    print("NO")