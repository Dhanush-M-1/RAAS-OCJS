n,m=[int(x) for x in input().split()]
s=set()
for i in range(n):
    x=[int(x) for x in input().split()]
    s.update(x[1:])
print(["NO","YES"][len(s)==m])