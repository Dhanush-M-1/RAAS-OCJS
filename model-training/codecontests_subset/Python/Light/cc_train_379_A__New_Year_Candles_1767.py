import math

two = input().split()

a, b = [int(item) for item in two] 

hours = a

while a > 1:
    hours += a/b
    a += -a/b * b + a/b
    
print(math.floor(hours))