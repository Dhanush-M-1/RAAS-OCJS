n = int(input())
ans = 1
x = list()
h = list()
for i in range(n):
    y = input().split()
    x.append(int(y[0]))
    h.append(int(y[1]))
last = x[0]
for i in range(1,n-1):
    if x[i] - h[i] > last:
        ans += 1
        last = x[i]
    elif x[i] + h[i] < x[i+1]:
        ans += 1
        last = x[i] + h[i]
    else:
        last = x[i]
print(ans + min(n-1,1))
