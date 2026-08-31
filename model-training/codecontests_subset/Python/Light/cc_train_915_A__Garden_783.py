n, k = input().split()
n, k = int(n), int(k)
M = list(map(int, input().split()))
H = []
for i in M:
    if k % i == 0 and i != 0:
        x = k//i
        H.append(x)
print(min(H))