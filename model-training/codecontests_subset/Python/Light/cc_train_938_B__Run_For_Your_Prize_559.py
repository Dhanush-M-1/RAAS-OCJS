n = int(input())
ls = list(map(int, input().split()))
ans = 0

for i in ls:
    if i > 500000:
        if 1000000 - i > ans:
            ans = 1000000 - i
        break 
    else:
        ans = i - 1   

print(ans)