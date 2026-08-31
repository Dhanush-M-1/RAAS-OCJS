a , b = [int(i) for i in input().split()]
c = a // b 
d = a % b
while c != 0:
    a += c
    c1 = c + d
    c = (c + d) // b
    if c1 < b:
        d = 0
    else:
        d = c1 % b
print(a)