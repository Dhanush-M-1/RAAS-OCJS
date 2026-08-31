n = int(input())
x_x = []
r_r = []
if n == 1:
    print(1)
    exit(0)
count = 2
for i in range(n):
    x, r = map(int, input().split())
    x_x.append(x)
    r_r.append(r)
for j in range(1, len(x_x) - 1):
    if x_x[j] - r_r[j] > x_x[j - 1]:
        count += 1
    elif x_x[j] + r_r[j] < x_x[j + 1]:
        x_x[j] = x_x[j] + r_r[j]
        count += 1
print(count)