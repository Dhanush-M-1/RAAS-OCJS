a,b = map(int,input().split())
ans = a
while True:
    ans += int(a/b)
    a = int(a/b) + a% b
    if int(a/b) == 0:
        break
print(ans)