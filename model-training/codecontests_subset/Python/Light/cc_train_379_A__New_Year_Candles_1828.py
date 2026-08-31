a, b = [int(i) for i in input().split(" ")]
hours = a; initial_candles = a
while(a // b > 0):
    a = a // b 
    hours += a
while(hours // b - (hours - initial_candles) > 0):   
    hours += hours // b - (hours - initial_candles)
print(hours)