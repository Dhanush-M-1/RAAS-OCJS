


a, b = input().split()

n = int(input())

print(a, b)

for _ in range(n):
    old, new = input().split()
    if old == a:
        a = new
    else:
        b = new
    print(a, b)
