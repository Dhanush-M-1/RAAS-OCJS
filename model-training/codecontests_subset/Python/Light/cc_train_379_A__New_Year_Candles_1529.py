a, b = [int(i) for i in input().split()]
c = 0
h = a

while 1:

    c = a // b
    a = c + (a % b)
    h = h + c

    if a < b :
        break

   
print(h)
    
    

