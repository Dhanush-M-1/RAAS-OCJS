n = int(input())
lol = list(map(int, input().split()))
a = 0
b = 0
for i in lol:
    if i <= 1000000 / 2:
        a = i -1
    else:
        b = 1000000 - i
        break
print(max(a, b))