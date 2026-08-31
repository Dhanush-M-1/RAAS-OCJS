import math

length = int(input().split(' ')[1])
elems = input().split(' ')

neededhours = math.inf

for elem in elems:
    hour = length/int(elem)
    if (math.floor(hour) == hour) & (hour < neededhours):
        neededhours = hour

print(math.floor(neededhours))