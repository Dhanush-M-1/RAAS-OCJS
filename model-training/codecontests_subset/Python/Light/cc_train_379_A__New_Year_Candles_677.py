line = input()
params = line.split(' ')
a = int(params[0])
b = int(params[1])

total_hours = a
candles = a

while candles >= b:
    total_hours += int(candles / b)
    candles = int((candles / b) + (candles % b))

print(total_hours)