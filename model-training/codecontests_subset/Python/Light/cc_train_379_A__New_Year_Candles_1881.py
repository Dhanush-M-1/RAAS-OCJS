a,b = map(int,input().split())
ans = 0
cnt = 0
while a > 0:
    ans = ans + 1
    a = a-1
    cnt = cnt + 1
    if cnt == b:
        a = a+1
        cnt = 0
print(ans)