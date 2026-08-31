candle,b = map(int,input().split())
i=0
h=0
while candle>0:
	
	candle-=1
	i+=1
	h+=1
	if i==b:
		candle+=1
		i=0
print(h)



