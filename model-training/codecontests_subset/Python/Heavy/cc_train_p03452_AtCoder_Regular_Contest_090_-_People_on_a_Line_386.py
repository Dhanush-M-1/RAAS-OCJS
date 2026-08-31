import sys
n,m=map(int,input().split())
lrd=[list(map(int,input().split())) for i in range(m)]
x=["a"]*(n+1)
#iより右にいるデータ
R=[[] for i in range(n+1)]
L=[[] for i in range(n+1)]
for u in lrd:
    l,r,d=u
    R[l].append([r,d])
    L[r].append([l,d])
for i in range(1,n+1):
    if x[i]=="a":
        x[i]=0
        que=[i]
        while que:
            h=que.pop()
            for u in R[h]:
                r,d=u
                if x[r]=="a":
                    x[r]=x[h]+d
                    que.append(r)
                else:
                    if x[r]==x[h]+d:
                        continue
                    else:
                        print("No")
                        sys.exit()
            for u in L[h]:
                l,d=u
                if x[l]=="a":
                    x[l]=x[h]-d
                    que.append(l)
                else:
                    if x[l]==x[h]-d:
                        continue
                    else:
                        print("No")
                        sys.exit()
print("Yes")