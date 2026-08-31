n,m = [int(i) for i in input().split()]
l1 = []
while(n):
    n-=1 
    l = [int(i) for i in input().split()]
    l1.extend(l[1:])
if len(set(l1)) == m:
    print("YES")
else:
    print("NO")
    