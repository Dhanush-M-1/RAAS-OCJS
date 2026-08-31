# https://codeforces.com/problemset/problem/379/A
a, b = map(int, input().split())

candles = a
burnt = 0

while candles >= b:
    burnt += (candles // b) * b
    candles = candles % b + candles // b

burnt += candles
print(burnt)