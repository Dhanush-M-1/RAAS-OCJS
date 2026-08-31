q=int(input())
ii=0
while ii<q:
    ii+=1
    l, r, d=map(int, input().split())
    if d<l:
        print(d)
    else:
        ans=r+1
        if ans%d==0:
            print(ans)
        else:
            ans+=d-ans%d
            print(ans)
