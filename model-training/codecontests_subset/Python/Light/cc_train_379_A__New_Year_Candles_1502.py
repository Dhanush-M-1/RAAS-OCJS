a,b=[int(x) for x in input().split()]
t=0
candle=0
while a>0:
    t+=1
    a-=1
    candle+=1
    if candle%b==0:
        c=int(candle/b)
        a+=c
        candle-=c*b
print(t)
