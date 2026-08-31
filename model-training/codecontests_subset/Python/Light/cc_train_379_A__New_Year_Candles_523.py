a,b = map(int,input().split())

output = a
candles = a//b
overflow = a%b

while candles >= 1 or overflow >=b:
	if overflow >= b:
		overflow-=b
		candles+=1

	output += candles
	a = candles
	candles = a//b
	overflow += a%b

print(output)