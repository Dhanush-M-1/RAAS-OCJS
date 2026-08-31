candles = input().split(' ')

number_of_candles = int(candles[0])
number_for_refactoring = int(candles[1])

hours = 0
busted_candles = 0

while number_of_candles:
    
    busted_candles += 1
    hours += 1
    number_of_candles -= 1

    if busted_candles % number_for_refactoring == 0:
        
        busted_candles -= number_for_refactoring
        number_of_candles += 1
        
print(hours)