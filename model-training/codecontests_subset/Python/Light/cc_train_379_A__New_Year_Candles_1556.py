s,r = list(map(int,input().split()))
candles = s
while(1):
    count = s//r
    s = count+(s%r)
    candles+=count
    if(s<r):
        break
print(candles)