c = int(input())
X = [float("-inf")]
H = [0]
for i in range(c):
    x, h = map(int, input().strip().split(" "))
    X.append(x)
    H.append(h)
X.append(float("inf"))
H.append(0)
cut = 2
for i in range(2, c):
    px, ph = X[i-1], H[i-1]
    nx, nh = X[i+1], H[i+1]
    x, h = X[i], H[i]
    if h < (x - px):
        cut += 1
    elif h < (nx - x):
        X[i] += h
        cut += 1
if c < 2:
    print(c)
else:
    print(cut)