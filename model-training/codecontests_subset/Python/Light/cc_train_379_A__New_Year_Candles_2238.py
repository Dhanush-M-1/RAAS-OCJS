candles, parts = map(int, input().split())

hours = candles
spare = 0

while candles > 0:
    new_candles = (candles + spare) // parts
    spare = (candles + spare) % parts
    candles = new_candles
    hours += candles
    
print(hours)