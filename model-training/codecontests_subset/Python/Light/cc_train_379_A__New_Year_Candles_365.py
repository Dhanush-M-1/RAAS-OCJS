##############
# Problem set : Soluton_Hub Coding Facebook Begineer
################
# X is Orignal candle and If X burn it makes Y candels
X, Y = list(map(int, input().split()))
# all for total number that take that candles
newCandels = 0
# while loop is checking new candles is greater than  original candels than stop making new candles
# X = 4 Y = 2
while (X >= Y):
    # newCandel = 2  newCandel = 4 newCandle = six
    # X = 2 , X = 3 X = 1 X = 2 X = 0 X = 1
    newCandels += Y
    X -= Y  ## X = X - Y 
    X = X + 1
print(X + newCandels)
