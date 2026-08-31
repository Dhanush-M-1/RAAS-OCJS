n,m = map(int,input().split())
ans = set()
for i in range(n):
    xy = list(map(int,input().split()))
    xy.pop(0)
    ans=ans | set(xy)
#     print(ans) 
if len(ans)==m:  
    print("YES")
else:
    print("NO")