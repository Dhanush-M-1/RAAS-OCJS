import math
x = list(map(int, input().split()))
b = []
s = []
for i in range(0,x[0]):
    s.append(list(map(int, input().split())))
for j in range(0,x[1]):
    b.append(0)
for i in range(0,x[0]):
    for j in range(1,len(s[i])):
        b[s[i][j]-1] = 1
for i in range(0,len(b)):
    if b[i] == 0:
        print("NO")
        exit()
print("YES")


