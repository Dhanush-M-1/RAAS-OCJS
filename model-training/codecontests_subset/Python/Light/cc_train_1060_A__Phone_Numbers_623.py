n = int(input())
s = [int(x) for x in input()]
c8 = s.count(8) 
phone = 0

if n >= 11 and c8 > 0:
    while n >= 11 and c8 > 0:
        c8 -= 1
        n -= 11
        phone += 1
    print(phone)
    
else:
    print(0)






