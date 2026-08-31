q=lambda:map(int,input().split())
qi=lambda:int(input())
qs=lambda:input().split()
n,m=q()
ans=set()
for i in range(n):
    a=list(q())
    ans.update(set(a[1:]))
print("YES" if len(ans)==m else 'NO')