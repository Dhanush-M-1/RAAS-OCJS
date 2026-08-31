inputLine = input()
inputList = inputLine.split(" ")
candle = int(inputList[0])
reuse = int(inputList[1])
time = 0
consume = 0
while candle != 0:
    candle -= 1
    consume += 1
    if consume // reuse == 1:
        candle += 1
        consume = 0
    time += 1
print(time)