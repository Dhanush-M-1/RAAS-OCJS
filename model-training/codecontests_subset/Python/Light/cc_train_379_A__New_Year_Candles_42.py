info = input().split()
a,b = [int(i) for i in info]
used = a
while a >= b:
    new = a//b
    a = a//b + a - a//b*b
    used += new

print (used)
