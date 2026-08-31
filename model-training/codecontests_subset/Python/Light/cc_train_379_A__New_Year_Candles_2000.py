new,b = list(map(int, input().split(' ')))
old = 0
ans = 0
while new !=0:
    ans = ans + new
    old = old + new
    new = int(old / b)
    old = old - (new * b)
print(ans)