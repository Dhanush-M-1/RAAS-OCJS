x, y = input().split()
n = int(input())
res = []
res.append((x,y))
for i in range(n):
    a , b = input().split()
    if a == x: x = b
    elif a == y: y = b
    res.append((x, y))

    
for a, b in res:
    print(a + " " + b)
