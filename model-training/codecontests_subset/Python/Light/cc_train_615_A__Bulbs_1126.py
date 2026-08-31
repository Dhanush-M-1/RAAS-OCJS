a,b = map(int,input().split())
c = [0] * b
for i in range(a):
    n = [int(s) for s in input().split()]
    for j in range(1,len(n)):
        c[n[j]-1] = 1
if (0) in(c):
    print("NO")
else:
    print("YES")
