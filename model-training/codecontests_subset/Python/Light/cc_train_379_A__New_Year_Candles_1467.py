x = input().split()
a = int(x[0])
b = int(x[1])
i = 0
z = 0
c = a
for i in range(a-1):
    c = c - b + 1
    if(c > 0):
        z += 1
    i += 1

print(z+a)
