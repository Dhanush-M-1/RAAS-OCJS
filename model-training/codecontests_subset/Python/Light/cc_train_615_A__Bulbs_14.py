n,m=list(map(int,input().split(" ")))
ans=[]
for i in range(0,n,1):
 x=list(map(int,input().split(" ")))
 for j in range(1,x[0]+1,1):
  if x[j] not in ans:
   ans.append(x[j])
  else:
   pass

if len(ans)>=m :
 print("YES")
else:
 print("NO")



