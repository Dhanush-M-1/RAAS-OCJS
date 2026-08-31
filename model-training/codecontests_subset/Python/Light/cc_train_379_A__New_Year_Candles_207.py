# https://codeforces.com/problemset/problem/379/A
numbers = input()
numbers = list(map(int, numbers.split()))
a = numbers[0]
b = numbers[1]
candles = a
answer = 0
while candles>=b:
    answer+= (candles//b)*b
    newCandles = candles//b
    newCandles+=candles%b
    candles = newCandles
print(answer+candles)
