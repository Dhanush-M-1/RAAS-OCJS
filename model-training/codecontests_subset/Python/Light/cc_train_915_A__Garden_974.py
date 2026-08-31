s = input().split()
n, k = int(s[0]), int(s[1])
s = input().split()
min_h = 101
for i in range(n):
    val = int(s[i])
    if k%val == 0 and k//val < min_h:
        min_h = k//val
print(min_h)

