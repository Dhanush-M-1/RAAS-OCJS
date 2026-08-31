n,m = (int(i) for i in input().split())

s = set()
for i in range(n):
    nextline = [int(j) for j in input().split()]
    for k in range(1, len(nextline)):
        s.add(nextline[k])
if len(s) == m:
    print ("YES")
else:
    print("NO")
    
