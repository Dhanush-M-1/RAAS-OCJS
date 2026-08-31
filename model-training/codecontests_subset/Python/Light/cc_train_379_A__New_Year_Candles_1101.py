a,b = map(int,input().split())
time = a
num = 0
while True and a > 0:
                num += a % b
                a =  a // b
                if num >= b:
                                num -= b
                                a += 1
                time += a
print(time)
             
