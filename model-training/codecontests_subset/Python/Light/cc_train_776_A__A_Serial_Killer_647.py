x, y = input().split(" ")
n = int(input())
print(x, y)
for i in range(n):
    a, b = input().split(" ")
    if a == x:
        x = b
    else:
        y = b
    print(x, y)
