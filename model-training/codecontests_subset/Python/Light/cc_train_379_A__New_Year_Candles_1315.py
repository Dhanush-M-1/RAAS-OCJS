a,b = map(int,input().split())
t = 0
l = 0
while a >0:
    t +=1
    a -=1
    l +=1
    if l >= b:
        a +=1
        l -=b
print(t)
        
