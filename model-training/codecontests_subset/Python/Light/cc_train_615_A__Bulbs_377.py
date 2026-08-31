s,b=[int(x) for x in input().split()]
l=[]
for i in range(s):
    k = [int(o) for o in input().split()]
    l+=k[1:len(k)]
if len(set(l)) == b:
    print('YES')
else:
    print('NO')
