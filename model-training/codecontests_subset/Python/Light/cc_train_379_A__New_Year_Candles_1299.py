a, b = input().split()
a = int(a)
b = int(b)
candles = a
stumps = 0
hours = 0
while candles>0:
    candles-=1
    stumps+=1
    hours+=1
    if stumps==b:
        stumps = 0
        candles+=1
print(hours)
