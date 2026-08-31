y = [int(i) for i in input().split()]
x = y[0]
y = y[1]
z = 0
a = 0
while x>0:
    z += 1
    x -= 1
    a += 1
    if a%y==0:
        x += 1
        a = 0
print(z)
    
