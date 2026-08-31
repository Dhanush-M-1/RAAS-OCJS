def New_Year_Candles(a, b):
    ans = a + (a-1)//(b-1)
    print(ans)
a, b = map(int, input().split())
New_Year_Candles(a, b)