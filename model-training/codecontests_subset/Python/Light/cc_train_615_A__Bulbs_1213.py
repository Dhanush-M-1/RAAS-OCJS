n,m = map(int,input().split())
s = set()
for i in range(n):
    s.update(input().split()[1:])
print(["NO","YES"][len(s)== m])