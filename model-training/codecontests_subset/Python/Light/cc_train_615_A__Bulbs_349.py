n,m=[int(x) for x in input().split()]
l = []
st=0
s = set(range(1,m+1))
for i in range(n):
    x = [int(x) for x in input().split()]
    for j in x[1:]:
        l.append(j)
st = set(l)
if st==s:
    print("YES")
else:
    print("NO")