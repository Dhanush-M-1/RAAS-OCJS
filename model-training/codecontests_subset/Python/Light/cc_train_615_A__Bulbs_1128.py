n,m=map(int,input().split())
S = set()
for i in range(n):
    l = input().split()
    for x in l[1:]:
        S.add(int(x))

if len(S) == m:
    print("YES")
else:
    print("NO")
