a, b = input().split()
n = int(input())
print(a, b)
for i in range(0, n):
    c, d = input().split()
    if a == c:
        a = d
    elif b == c:
        b = d
    print(a, b)
