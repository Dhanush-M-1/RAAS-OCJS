n, m = map(int, input().split())
b = []

for i in range(n):
    b.append(list(map(int, input().split()))[1:])
    
a = [0]*m

for i in range(n):
    for j in b[i]:
        a[j-1] = 1
        
if 0 in a:
    print("NO")
else:
    print("YES")