n=int(input())
l = []
for i in range(n):
    data = list(map(int, input().split()))
    l.append(data)
ans = 0
occupied = - float('inf')
for i in range(n):
    #try left
    xl = l[i][0]-l[i][1]
    xr = l[i][0]+l[i][1]
    if xl>occupied:
        ans+=1
        occupied = l[i][0]
    elif i==n-1:
        ans+=1
    elif xr<l[i+1][0]:
        ans+=1
        occupied = xr
    else:
        occupied = l[i][0]
print(ans)