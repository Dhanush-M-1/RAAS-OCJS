n, bulb= (map(int, input().split()))
b = []

count = 0
for x in range(n):
    a = list(map(int, input().split()))
    for y in range(int(a[0])):
        b.append(a[y+1])
        
if len(set(b)) == bulb :
    print("YES")
else:
    print("NO")
