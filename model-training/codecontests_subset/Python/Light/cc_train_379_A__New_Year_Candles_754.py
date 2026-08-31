d = input().split()
a,b = int(d[0]), int(d[1])
y = 0
x = 0
while a >0:
    a-=1
    x+=1
    y+=1
    if y == b:
        a+=1
        y=0
print(x)