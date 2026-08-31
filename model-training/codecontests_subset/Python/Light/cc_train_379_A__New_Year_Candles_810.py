n=list(map(int,input().split()))
a=n[0]
b=n[1]
candles=0
count=0
while(a!=0):
    candles+=1
    count+=1
    a-=1
    #print(candles,count)
    if candles==b:
        a+=1
        candles=0

print(count)

