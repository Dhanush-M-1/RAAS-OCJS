q = input().split(' ')
a = int(q[0])
b = int(q[1])

c = a
o = a

while o >= b:
    c += o // b
    o = o % b + o // b

print(c)
