a, b = input().split()
n = int(input())
for i in range(n):
    c, d = input().split()
    print(a, b)
    if c == a:
        a = d
    else:
        b = d
print(a, b)