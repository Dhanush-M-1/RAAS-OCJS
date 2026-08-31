n = int(input())
pair = []
for i in range(n):
    x, h = map(int, input().split())
    pair.append((x, h))

count = 1
pre = pair[0][0]
for i in range(1, n-1):
    c = pair[i]
    nt = pair[i+1]
    if c[0] - pre > c[1]:
        count += 1
        pre = c[0]
    elif nt[0] - c[0] > c[1]:
        count += 1
        pre = c[0] + c[1]
        continue

    pre = c[0]

if n==1:
    print(1)
else:
    print(count+1)