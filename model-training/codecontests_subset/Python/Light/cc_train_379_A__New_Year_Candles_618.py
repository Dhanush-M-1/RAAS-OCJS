#379A-New Year Candle
a,b=map(int,input().split(' '))
t=0
c=0
while True:
    t+=a
    d=int((a+c)/b)
    c=(a+c) % b
    a=d
    if a == 0:
        break
print(t)
    
    
    
