# a, b = map(int, input().split())
#
# hour = 0
# new_candle = a // b
# new_hour = a % b
#
# while a > 0:
#     hour += 1
#     a -= 1
#     if a == 0:
#         hour += new_candle
#     if new_hour == 0 and a == 0 and new_candle % b == 0:
#         hour += 1
# print(hour)

a, b = map(int, input().split())

hour = 0

while a > 0:
    hour += 1
    a -= 1
    if hour % b == 0:
        a += 1
print(hour)