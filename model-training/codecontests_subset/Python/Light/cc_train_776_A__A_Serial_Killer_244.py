ans=[list(input().split())]
n=int(input())
for _ in range(n):
    x,y=input().split()
    xo,yo=ans[-1][0],ans[-1][1]
    if xo==x:
        ans+=[[y,yo]]
    else:
        ans+=[[xo,y]]
for i in range(n+1):
    ans[i]=' '.join(ans[i])
print('\n'.join(ans))