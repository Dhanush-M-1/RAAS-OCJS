number=int(input())
l=[list(map(int,input().split())) for i in range(number)]
lp=[i[0] for i in l]
lh=[i[1] for i in l]
l2=[10**9+1]+[lp[i+1]-lp[i] for i in range(number-1)]+[10**9+1]

ans=0
hb=l2[0]
for i in range(len(lh)):
    ha=l2[i+1]
    h=lh[i]
    if h<hb:
        ans+=1
        hb=ha
        continue
    if h<ha:
        ans += 1
        hb=ha-h
        continue
    else:
        hb=ha
print(ans)