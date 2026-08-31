import math
inputNums = input()

a = int(inputNums.split(" ")[0])
b = int(inputNums.split(" ")[1])


burnedCandles = count = 0

for i in range(a):
    count += 1

    burnedCandles += 1

    if burnedCandles == b:
        count += 1
        burnedCandles = 1

print(count)
