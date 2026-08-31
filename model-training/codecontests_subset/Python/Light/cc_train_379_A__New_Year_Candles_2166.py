import math
a,b = [int(x) for x in input().split()]

r = a

while a >= 1:
    a = a/b
    r += a
    
print(math.floor(r))