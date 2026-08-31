n,k=map(int,input().split())
aa,bb,cc=[0],[0],[0]
for _ in range(n):
    t,a,b=map(int,input().split())
    if a==b and a==1:
        cc.append(t)
    elif a==1:
        aa.append(t)
    elif b==1:
        bb.append(t)
aa.sort()
bb.sort()
cc.sort()
for i in range(1,len(aa)):
    aa[i]=aa[i-1]+aa[i]
for i in range(1,len(bb)):
    bb[i]=bb[i-1]+bb[i]
for i in range(1,len(cc)):
    cc[i]=cc[i-1]+cc[i]
if len(cc)+len(bb)<k+2 or len(cc)+len(aa)<k+2:
    print(-1)
else:
    ans=float('inf')
    for i in range(max(0,k-min(len(aa)-1,len(bb)-1)),min(len(cc),k+1)):
        ans=min(ans,cc[i]+bb[k-i]+aa[k-i])
    print(ans)