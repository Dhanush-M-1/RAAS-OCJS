Candle_input=input("")
Candle_input = Candle_input.split(" ")

remaining_total = int(Candle_input[0]) #total candles
recharge = int(Candle_input[1]) #recharge for one candle
hours_of_light = 0

while (remaining_total>0):
    if remaining_total >= recharge:
        remaining_total = remaining_total - recharge
        hours_of_light = hours_of_light + recharge
        remaining_total = remaining_total + 1
    else:
        hours_of_light = hours_of_light + remaining_total
        remaining_total = 0

print(hours_of_light)

