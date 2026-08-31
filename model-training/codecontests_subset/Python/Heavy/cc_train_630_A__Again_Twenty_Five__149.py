'''import math
a = input().split()
b = int(a[0])
c = int(a[1])
d = int(a[2])
e = math.ceil(b/d)
f = math.ceil(c/d)
print(e * f)'''

'''desk = input().split()
a = int(desk[0])
b = int(desk[1])
s = a * b
print(s//2)'''

'''a = int(input())
x = 0
for i in range(a):
    b = input()
    if '++' in b:
        x += 1
    elif '--' in b:
        x -= 1
print(x)'''

'''a = input().split()
b = int(a[0])
c = int(a[1])
for i in range(c):
    d = b % 10
    if d != 0:
        b -= 1
    elif d == 0:
        b = b // 10
print(b)'''

print(25)
