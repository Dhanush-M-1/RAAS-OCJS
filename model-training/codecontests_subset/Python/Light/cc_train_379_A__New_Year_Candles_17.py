a, b = [int(x) for x in input().split()]
ans  = a + (a - 1)//(b - 1)
print(ans)