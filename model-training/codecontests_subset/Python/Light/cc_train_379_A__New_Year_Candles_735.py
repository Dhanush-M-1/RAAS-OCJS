sa=input().split(' ')
a=int(sa[0])
b=int(sa[1])
candles=0
lefts=0
while a>0:
    candles+=1
    a-=1
    lefts+=1
    if lefts==b:
        a+=1
        lefts=0
print(candles)
