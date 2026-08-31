n, k = list(map(int, input().split()))
a = list(map(int, input().split()))
x = 0
for i in a:
    if k % i == 0 and i > x:
        x = i
print(k // x)