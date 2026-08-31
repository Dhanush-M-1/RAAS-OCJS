n , m = map(int,input().split())
ans=[]
for i in range(n):
    lis=list(map(int,input().split()))
    ans.extend(lis[1:])
s=set(ans)    
if len(s)==m:
    print("YES")
else:
    print("NO")        