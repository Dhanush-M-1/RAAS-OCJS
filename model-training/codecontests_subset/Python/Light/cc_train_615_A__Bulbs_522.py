n,m = map(int,input().split())
s = []
for i in range(n):
    h = list(map(int,input().split()))
    for j in range(1,len(h)):
        s.append(h[j])
s = list(set(s))
if len(s) == m:
    print("YES")
else:
    print("NO")