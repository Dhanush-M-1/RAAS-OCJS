import math
a,b = map(int,input().split())
candles = a
rem = 0
for i in range(math.floor(math.log(a,b))+1):
	candles += a//b
	a = a//b + a%b
print(candles)