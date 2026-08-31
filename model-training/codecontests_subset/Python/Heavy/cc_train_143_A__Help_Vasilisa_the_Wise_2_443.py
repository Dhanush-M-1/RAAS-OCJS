r=list(map(int,input().split()))
c=list(map(int,input().split()))
d=list(map(int,input().split()))
X=0
for i in range(1,10):
    ans1=[0,0]
    ans2=[0,0]
    if i<=d[0] and i<=r[0] and i<=c[0]:
        ans1[0]=i
        ans2[1]=d[0]-ans1[0]
        ans1[1]=abs(r[0]-ans1[0])
        if ans1[1]+ans2[1]==c[1]:
            ans2[0]=abs(r[1]-ans2[1])
            if ans1[0]>9 or ans1[1]>9 or ans2[0]>9 or ans2[1]>9 or len(set(ans1))!=2 and len(set(ans2))!=2 or ans1[0]==ans2[0] or ans1[1]==ans2[0] or ans1[0]==ans2[1] or ans1[1]==ans2[1] or 0 in ans1 or 0 in ans2:
                print(-1)
                X=1
            elif len(set(ans1))==2 and len(set(ans2))==2 and ans2[0]+ans1[1]==d[1]:
                print(*ans1,sep=' ')
                print(*ans2,sep=' ')
                X=1
            else:
                print(-1)
                X=1
    else:
        continue
if X==0:
    print(-1)


