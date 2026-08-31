import sys
n,m = map(int,input().split())
a = list(map(int,sys.stdin))
a.append(0)
prev=0
cur=1
m=0
for i in range(1,n+1):
  if a[m]==i:
    prev,cur = cur,0
    m += 1
  else:
    prev,cur = cur,(cur+prev)%1000000007
print(cur)