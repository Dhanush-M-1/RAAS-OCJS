base_candle, need_for_new_candle = map(int, input().split(' '))
time = base_candle
burnt_candle = base_candle
while (burnt_candle >= need_for_new_candle):
    new_candle = burnt_candle // need_for_new_candle
    burnt_candle %= need_for_new_candle
    burnt_candle += new_candle
    time += new_candle
print(time)
