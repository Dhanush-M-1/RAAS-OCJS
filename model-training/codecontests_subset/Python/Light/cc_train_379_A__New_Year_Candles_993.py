# New Year Candles
def candles(a, b):
    ans = 0
    while a >= b:
        ans += b
        a -= b
        a += 1
    return ans + a




a, b = list(map(int, input().rstrip().split()))
print(candles(a, b))