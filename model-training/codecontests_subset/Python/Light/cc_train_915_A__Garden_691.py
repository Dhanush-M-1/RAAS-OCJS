n, k = list(map(int, input().split()))
l = list(map(int, input().split()))
h = 1e99
for elem in l:
    if not k % elem:
        h = min(h, k // elem)
print(h)
