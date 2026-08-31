MAX=1e6

n=int(input())
ar=list(map(int,input().split()))

var = 0
for i in ar:
  if i<(MAX//2): var = max(var,i-1)
  elif i==(MAX//2): var = max(var,min(i-1,MAX-i))
  else: var = max(var,MAX-i)

print(int(var))
