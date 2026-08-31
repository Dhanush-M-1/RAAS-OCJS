p = input().strip()
n = int(input())
r = 0
s = [0] * n
for i in range(n):
    s[i] = input().strip()
for i in range(n):
    for j in range(n):
        if p in s[i] + s[j]:
            r = 1
if r:
    print("YES")
else:
    print("NO")