n = int(input())
a = list(map(int, input().split()))
l = 1
mil = 1000000
r = mil
for i in a:
    if i - 1 < mil - i:
        l = i
    else:
        r = i
        break
print(max(l - 1, mil - r))
