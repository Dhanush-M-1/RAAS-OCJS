n, m = map(int, input().split())
bulbState = [False] * m
x = []
y = []
for i in range(n):
    s = input().split()
    x = int(s[0])
    for j in range(x):
        y.append(int(s[j+1]))
for i in y:
    bulbState[i-1] = True
if(False in bulbState):
    print('NO')
else:
    print('YES')