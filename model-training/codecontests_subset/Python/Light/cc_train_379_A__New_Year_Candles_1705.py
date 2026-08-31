l = [int(i) for i in input().split()]

x = l[0]
b = l[1]
m = 0
w = 0
while(x != 0):
    m = x + m
    w = w + x
    x = w // b
    w = w % b
print(m)