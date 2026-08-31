from math import floor
x =input().split()
a =int(x[0])
b =int(x[1])
hours = 0
unused =.01
used = a
while used>=1:
    hours+=used
    cache = used//b
    unused =unused+(used%b)/b
    used = cache+floor(unused)
    unused= unused-floor(unused)
    
print(hours)