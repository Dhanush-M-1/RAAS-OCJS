t=int(input())
for v in range(t):
    adj=[]
    n=int(input())
    for i in range(n):
        li=list(map(int,input().split(" ")))
        adj.append(li)
    li=adj[0]

    if li[1]>li[0]:
        print("NO")
        continue
    else:
        flag=1
        for j in range(1,n):
            pr=adj[j-1]
            li=adj[j]
            if li[1]>li[0]:
                flag=0
                break
            if li[0]<pr[0]:
                flag=0
                break
            if li[1]<pr[1]:
                flag=0
                break
            if li[0]==pr[0] and pr[1]!=li[1]:
                flag=0
                break
            if li[1]-pr[1]>li[0]-pr[0]:
                flag=0
                break
    if flag:
        print("YES")
    else:
        print("NO")

