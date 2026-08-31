n , m = map(int,input().split())
ans = 0
i = 0
while True :
    n -= 1
    i += 1
    ans += 1
    if i == m :
        i = 0
        n += 1
    if n == 0 : break
print(ans)
