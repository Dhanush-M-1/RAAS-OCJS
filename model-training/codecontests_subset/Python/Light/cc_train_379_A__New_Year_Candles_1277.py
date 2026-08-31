import sys
candles = sys.stdin.readline().strip().split(' ')
a = int(candles[0])
b = int(candles[1])
c = 0

while(a >= b):
	c += b
	a -= b
	a += 1
print(c + a)
