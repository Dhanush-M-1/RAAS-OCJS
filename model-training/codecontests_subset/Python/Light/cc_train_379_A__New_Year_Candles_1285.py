def candles(a,b):
	c = a
	while(a >= b):
		c += a//b
		x = a % b
		a //= b
		a += x
	return c

a,b = input().split()
a,b = int(a),int(b)

print(candles(a,b))