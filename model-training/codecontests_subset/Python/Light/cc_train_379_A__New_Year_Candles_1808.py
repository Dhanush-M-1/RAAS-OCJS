a , b = [ int(i) for i in input().split() ]
 
total = a + a // b
x = (a // b) + (a % b)
while (x >= b) :
    if x == 1 :
        break
    y = x % b
    x = x // b
    total += x
    x += y
print(total)    
