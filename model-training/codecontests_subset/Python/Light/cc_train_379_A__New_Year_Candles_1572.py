a,b=map(int,input().split())
hours=a
candles=a
while candles>=b:
	hours+=(candles//b)
	#print(f"candles={candles} hours={hours}")
	candles=candles%b+candles//b
print(hours)