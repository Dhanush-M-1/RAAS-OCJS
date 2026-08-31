l=list(map(int,input().split(" ")))
candles=l[0]
b=l[1]
time=0
waste=0
k=0
while(candles>0):
	time=time+candles
	waste=candles
	candles=int((waste+k)/b)
	k=(waste+k)%b
print(time)