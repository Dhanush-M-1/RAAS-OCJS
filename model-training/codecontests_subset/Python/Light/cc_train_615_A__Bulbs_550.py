n,m = [int(x) for x in input().split()]
s = []

for i in range(1,m+1):
    s.append(i)

counter=0

for i in range(n):
    q = [int(x) for x in input().split()]
    q[0]=-1
    for k in q:
        if k in s:
            counter+=1
            s.remove(k)

if counter==m:
    print("YES")
else:
    print("NO")
    