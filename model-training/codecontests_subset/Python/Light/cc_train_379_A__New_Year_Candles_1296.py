l1 = [int(x) for x in input().split()]
candles, mod = l1[0],l1[1]
ans = 0
unused = 0
while candles:
    #print(candles,unused)
    ans+=candles
    if int((unused+candles)/mod)>int(candles/mod):
        temp = (unused+candles)%mod
        candles = int((unused+candles)/mod)
        unused = temp
    else:
        unused+=candles%mod
        candles =int(candles/mod)
print(ans)