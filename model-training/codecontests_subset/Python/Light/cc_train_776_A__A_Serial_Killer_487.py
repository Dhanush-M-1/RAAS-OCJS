a, b = input().split()
n = int(input())

print(a, b)
for i in range(n):
    a1, b1 = input().split()
    if a == a1:
        a = b1
    else:
        b = b1
    print(a, b)