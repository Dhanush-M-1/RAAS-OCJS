x=input()
x=x.split()
candles=int(x[0])
temp=candles
re=int(x[1])
flag=0
while candles>=re:
  candles=candles-re
  candles=candles+1
  flag=flag+1
print(temp+flag)  

