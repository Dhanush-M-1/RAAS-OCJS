n=int(input())
h=[]
for i in range(n):
    h.append(list(map(int,input().split())))
ans=0
for i in range(n):
    if i==0 or i==n-1:
        ans=ans+1
    else:
        if h[i][1]<h[i][0]-h[i-1][0]:
            ans=ans+1
        elif h[i][1]<h[i+1][0]-h[i][0]:
            ans=ans+1
            h[i][0]=h[i][0]+h[i][1]
print(ans)