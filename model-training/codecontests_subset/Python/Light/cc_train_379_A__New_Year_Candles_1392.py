a = input().split()
b = int(a[1])
a = int(a[0])
answ = 0
x = 0
while a != 0:
    a -= 1
    answ += 1
    x += 1
    if x == b:
        x = 0
        a += 1
print(answ)