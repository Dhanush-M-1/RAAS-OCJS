numbers = [int(i)for i in input().split()]
a = numbers[0]
b = numbers[1]
remain = 0
candles = a
worn = 0
total = 0
while True:
    hours = candles
    total+=hours
    if hours==0:
        break
    worn = candles+remain
    candles = 0
    hours = 0
    candles = worn//b
    remain = worn%b
    
print(total)
