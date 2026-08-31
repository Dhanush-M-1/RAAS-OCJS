inp1=list(map(int,input().split()))
s=set()
for x in range(inp1[0]):
    inp2=input().split()
    del inp2[0]
    s.update(set(inp2))
if len(s)==int(inp1[1]):
    print('YES')
else:
    print('NO')