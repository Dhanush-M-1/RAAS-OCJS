import sys

in_str = (sys.stdin.readline()).split()

a = int(in_str[0])
b = int(in_str[1])

hours = a

while(a >= b):    
    ost = int(a % b)
    a = int(a / b)
    hours += int(a) 
    a += ost
    
print(hours)  