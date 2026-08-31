X,Y = input().split()
x = int(X)
y = int(Y)
candles = x

while x >= y :
    new = x // y
    reserve = x - (new*y)
    x = new + reserve
    candles = candles + new


print(candles)
