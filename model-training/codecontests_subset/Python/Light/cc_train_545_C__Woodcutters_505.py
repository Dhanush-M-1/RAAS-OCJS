n = int(input())

inf = 2000000001

xs = [-inf]
hs = [1]

for i in range(n):
    x, h = map(int, input().split())
    xs.append(x)
    hs.append(h)

xs.append(inf)
hs.append(1)

sol = 0
last_cut_x = xs[0]

for i in range(1, len(xs) - 1):
    if xs[i] - hs[i] > xs[i-1] and xs[i] - hs[i] > last_cut_x:
        sol += 1
    elif xs[i] + hs[i] < xs[i+1]:
        sol += 1
        last_cut_x = xs[i] + hs[i]

print (sol)
