n = int(input())
x = []
h = []
for i in range(n):
    xx, hh = map(int, input().split())
    x.append(xx)
    h.append(hh)

if n == 1:
    print(1)
else:
    k = 2
    rightest = x[0]
    for i in range(1, n - 1):
        if x[i] - h[i] > rightest:
            rightest = x[i]
            k += 1
        elif x[i] + h[i] < x[i + 1]:
            rightest = x[i] + h[i]
            k += 1
        else:
            rightest = x[i]
    print(k)
