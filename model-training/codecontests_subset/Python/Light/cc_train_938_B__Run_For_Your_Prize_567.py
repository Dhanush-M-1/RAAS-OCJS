a = input()
a = input().split(" ")
a = [int(i) for i in a]
a = sorted(a)
ii = 1
j = 10**6
ans = min(abs(a[0]-ii),abs(a[0]-j))
for i in a:
    ans = max(min(abs(i-ii),abs(i-j)),ans)
print(ans)
