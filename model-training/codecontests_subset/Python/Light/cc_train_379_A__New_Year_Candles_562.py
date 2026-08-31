s = input()
l = s.split()
n = int(l[0])
m = int(l[1])
a = n
while n // m != 0:
    k = n-(m*(n//m))
    n = n//m
    a += n
    n += k
print(a)
