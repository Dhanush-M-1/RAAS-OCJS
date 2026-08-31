n, k = map(int, input().split())
a = list(map(int, input().split()))
mx = k + 1
for c in a:
    if k % c == 0 and k // c < mx:
        mx = k // c

print(mx)
