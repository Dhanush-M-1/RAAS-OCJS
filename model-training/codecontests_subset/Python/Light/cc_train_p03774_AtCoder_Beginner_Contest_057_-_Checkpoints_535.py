n,m=map(int,input().split())
stu=[list(map(int,input().split()))for i in range(n)]
po=[list(map(int,input().split()))for i in range(m)]
for i in stu:
    tmp=10**12
    for j in po:
        ab=abs(i[0]-j[0])+abs(i[1]-j[1])
        if ab<tmp:
            tmp=ab
            ans=po.index(j)
    print(ans+1)