n = int(input())

firsttime = 0
for x in input().split():
    firsttime += int(x)

secondtime = 0 
for y in input().split():
    secondtime += int(y)

thirdtime = 0 
for z in input().split():
    thirdtime += int(z)

print(firsttime - secondtime)
print(secondtime - thirdtime)