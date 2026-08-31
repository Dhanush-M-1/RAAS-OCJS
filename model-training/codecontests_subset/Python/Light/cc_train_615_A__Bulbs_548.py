R = lambda : map(int, input().split())
n,m=R()
s=set()
for _ in range(n):
    x = [_ for _ in R()]
    for i in range(1,len(x)):
        s.add(x[i])

if len(s)==m:
    print("YES")
else:
    print("NO")