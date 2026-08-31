s = input().split(' ')

candles = int(s[0])
b = int(s[1])
h = 0
left = 0

while(candles > 0):
	h += candles
	left += candles
	candles = left // b
	left = left % b

print(h)