n = int(input())

x = [0]*(n+1)
h = [0]*(n+1)
l = [0]*(n+1)
r = [0]*(n+1)

inf  = 10**10

for i in range (0,n) :
    x[i],h[i] = map(int,input().split(" "))

x[n] = inf
l[0] = 1
if x[0]+h[0]<x[1] : r[0] = 1


for i in range (1,n) :
    l[i] = max(l[i-1],r[i-1])
    r[i] = max(l[i-1],r[i-1])
    if x[i-1]+h[i-1]<x[i]-h[i] : l[i] = max(l[i],r[i-1]+1)
    if x[i]-h[i]>x[i-1] : l[i] = max(l[i],l[i-1]+1)
    if x[i]+h[i]<x[i+1] : r[i] = max(r[i],max(l[i-1],r[i-1])+1)

print(max(r[n-1],l[n-1]))