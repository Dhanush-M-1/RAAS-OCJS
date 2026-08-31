n,m = map(int,input().split())
s = set()
for x in range(n):
    b = [int(y) for y in input().split()][1:]
    for x in b:
        s.add(x)
        
print (('NO','YES')[len(s)==m])