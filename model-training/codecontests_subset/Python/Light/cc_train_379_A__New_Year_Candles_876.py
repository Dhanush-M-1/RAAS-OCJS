import math

a, b = map(int, input().split())

count = a
ost = 0

while True :
    ost = a - b * math.floor( a / b) + ost 
    a = math.floor( a / b)
    count += a
    if a == 0 :
        if ost < b :
            break
        else :
            a = ost
            ost = 0
    
print(count)
