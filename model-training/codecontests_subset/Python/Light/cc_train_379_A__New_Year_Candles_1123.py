n,m = map(int,input().split())
candles = []
for i in range(1,n+1):
    candles.append(i)
for item in candles:
    if item%m == 0:
        n = n+1
        candles.append(n)
print(max(candles)) 