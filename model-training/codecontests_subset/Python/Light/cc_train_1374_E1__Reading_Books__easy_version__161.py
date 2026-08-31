n,k=map(int,input().split())
l=[]
ll=[]
lll=[]

for i in range(n):
  t,a,b=map(int,input().split())
  if a==1 and b==1:
    l.append(t)
  elif a==1:
    ll.append(t)
  elif b==1:
    lll.append(t)

ll.sort()
lll.sort()
for i in range(min(len(ll),len(lll))):
  l.append(ll[i]+lll[i])

we=len(l)
if k>we:
  print(-1)
else:
  l.sort()
  ans=0
  for i in range(k):
    ans+=l[i]
  
  print(ans)
