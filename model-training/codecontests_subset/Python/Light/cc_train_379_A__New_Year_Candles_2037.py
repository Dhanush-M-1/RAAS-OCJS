def get_hours_by_spent_candles(candles, div):
	if candles < div:
		return 0
	else:
		res = candles % div
		candles = int(candles / div)
		return candles + get_hours_by_spent_candles(candles + res, div)

candles, div = [int(x) for x in input().split(' ')]
print(candles + get_hours_by_spent_candles(candles, div))