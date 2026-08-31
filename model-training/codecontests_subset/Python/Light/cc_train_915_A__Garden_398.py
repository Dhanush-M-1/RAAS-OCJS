c, b = input().split()
n = int(c)
k = int(b)
b = input().split()
a = []
for x in range(n):
    a.append(int(b[x]))
a.sort()
a.reverse()
for x in range(n):
    if (k % a[x] == 0):
        print(k // a[x])
        break
    
