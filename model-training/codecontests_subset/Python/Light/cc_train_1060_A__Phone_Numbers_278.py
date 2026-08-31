n = int(input())
s = input()

cnt = 0
for i in s:
    if i == '8':
        cnt += 1

ans = 0
for i in range(0, cnt+1):
    if i*11 <= n:
       ans = i
    else:
        break

print(ans)

