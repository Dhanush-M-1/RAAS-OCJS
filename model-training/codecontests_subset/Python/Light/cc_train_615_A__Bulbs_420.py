n,m = map(int,input().strip().split())
nl = []
c = 0
for i in range (n):
    lst = list(map(int,input().strip().split()))
    nl+=(lst[1:])
    nl.sort()
for i in range (1,m+1):
    if i not in nl:
        c = 1
        break
if c==0:
    print("YES")
else:
    print("NO")