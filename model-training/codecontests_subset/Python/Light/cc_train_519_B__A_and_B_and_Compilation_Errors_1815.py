n = int(input())
a = [num for num in input().split()]
b = [num for num in input().split()]
c = [num for num in input().split()]
x = "x"
y = "y"
a.sort()
b.sort()
c.sort()

for i in range(n-1):
    if a[i] != b[i]:
        x = a[i]
        break
if x == "x":
    x = a[n-1]

for i in range(n-2):
    if b[i] != c[i]:
        y = b[i]
        break
if y =="y":
    y = b[n-2]
    
print(x)
print(y)