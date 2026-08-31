a,b=map(int,input().split())
candles=a
while (a//b>0):
  candles += a//b
  a=a//b+a%b
print (candles)  