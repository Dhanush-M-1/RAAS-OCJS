line = input().split()
a = int(line[0])
b = int(line[1])
hour = 0
total = a
burned = 0
while(total > 0):
    total -= 1
    burned += 1
    if(burned % b == 0):
        total += 1
    hour += 1
print(str(hour))
