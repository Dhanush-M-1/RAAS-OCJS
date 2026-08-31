candles = input().split()
new_candles = int(candles[0])
burnt_candles = int(candles[1])

hours = new_candles

while new_candles >= burnt_candles:
	hours += new_candles // burnt_candles
	new_candles = (new_candles % burnt_candles) + (new_candles // burnt_candles)

print(int(hours))