o = input().split()
n = int(o[0])
m = int(o[1])
b = [1] + [0] * m
for i in range(n):
    x = input().split()
    del x[0]
    for j in x:
        b[int(j)] = 1
if 0 in b:
    print("NO")
else:
    print("YES")