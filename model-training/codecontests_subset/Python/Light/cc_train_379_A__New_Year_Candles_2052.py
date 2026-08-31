# NEW YEAR CANDLES(379A)

a,b = map(int,input().split())
res = a
while(a >= b):
    d = a//b
    res += d
    m = a % b
    a = d + m
print(res)