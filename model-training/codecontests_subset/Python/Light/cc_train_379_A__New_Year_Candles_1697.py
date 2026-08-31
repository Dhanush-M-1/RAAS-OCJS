a, b = map(int, input().split())
ans = a
rest = 0

while a:
    t = (a+rest)
    a = t//b
    rest = t%b
    ans += a
    
print(ans)
