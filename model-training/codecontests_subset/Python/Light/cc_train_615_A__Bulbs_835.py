n,m=map(int,input().split())
z=[]
for i in range(n):
  l=list(map(int,input().split()))
  z.append(l[1:])
cnt=[]
for i in z:
  cnt+=i
if len(set(cnt))==m:
  print("YES")
else:
  print("NO")