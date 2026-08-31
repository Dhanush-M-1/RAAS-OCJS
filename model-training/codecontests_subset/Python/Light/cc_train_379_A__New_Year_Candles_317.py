from sys import stdin

# a number of candles
# b make a new candle
# t number of total candles

a, b = [int(c) for c in stdin.readline().split()]
burnt = 0
burnt_candle = 0
# c candles remaining
time = 0

def re(candle, burnt_candle):
    global time
    time = time + candle
    burnt_candle = burnt_candle + candle
    candle = burnt_candle//b
    burnt_candle = burnt_candle - candle*b
    if candle>0:
        return re(candle, burnt_candle)
    else:
        return time

print(re(a,0))
