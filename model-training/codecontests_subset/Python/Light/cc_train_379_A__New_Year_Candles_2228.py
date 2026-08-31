a, b = input().split()
a, b = int(a), int(b)

hours = a

while a >= b:
    hours = hours + (a // b)
    a = (a//b) + (a%b)
    
print(hours)