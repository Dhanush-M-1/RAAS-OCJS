buttons, bulbs = map(int,input().split())
d = dict()
for i in range(buttons):
    raw = list(map(int,input().split()))
    d[i] = raw[1:]
possibilities = set([i for i in range(1,bulbs+1)])

for k,v in d.items():
    v2 = set(v)
    possibilities.difference_update(v2)
    
if possibilities:
    print("NO")
else:
    print("YES")