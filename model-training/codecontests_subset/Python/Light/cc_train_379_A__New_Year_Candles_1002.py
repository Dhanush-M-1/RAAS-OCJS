thing = input()
thing = thing.split(" ")
a=int(thing[0])
b=int(thing[1])
time = 0
newCandles = a
oldCandles = 0
while oldCandles >= b or newCandles > 0:
    time += newCandles
    oldCandles += newCandles
    newCandles = int(oldCandles/b)
    oldCandles -= b*int(oldCandles/b)
print (time)
