candles = input().split()

original_candles = int(candles[0])
new_candles = int(candles[1])


used_candles = original_candles
wax_left = original_candles

while (wax_left-new_candles) >= 0:
	used_candles = used_candles + 1
	wax_left = (wax_left - new_candles) + 1


print(used_candles)