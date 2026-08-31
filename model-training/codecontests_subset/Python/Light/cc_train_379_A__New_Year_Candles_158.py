a,b = map(int, input().split())
candles = a
while(a>=b):
	candles += a//b
	a = a//b + a%b
	
print(candles)
