a,b = [int(i) for i in input().split()]

t = a
while t//b>0:
        a += t//b
        t = t//b + t%b

print(a)