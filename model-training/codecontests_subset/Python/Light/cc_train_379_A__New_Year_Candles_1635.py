a, b = list(map(int, input().split()))
i = 0
ans = 0
c = 0
while a > 0:
    ans = ans + a
    mergedCandles = a + c
    a = mergedCandles // b
    c = mergedCandles % b
    i += 1
print(ans)
