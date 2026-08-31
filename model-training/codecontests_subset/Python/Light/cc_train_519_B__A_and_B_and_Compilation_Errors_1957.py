f = lambda: map(int, input().split())
n = int(input())

s1 = sorted(list(f()))
s2 = sorted(list(f()))
s3 = sorted(list(f()))

for i in range(n):
    if i == n - 1 or s1[i] != s2[i]:
        print(s1[i])
        break
for i in range(n - 1):
    if i == n - 2 or s2[i] != s3[i]:
        print(s2[i])
        break