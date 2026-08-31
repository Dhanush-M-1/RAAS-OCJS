#Candles

c = 0
a, b = map(int, input().split())
hours = a
while True:
    if a < b:
        break
    hours += a // b
    a = a // b + a % b
print(hours)