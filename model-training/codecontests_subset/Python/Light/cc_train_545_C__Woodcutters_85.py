n = int(input())
x = []
h = []
num = 2
for i in range(n):
    a,b = map(int,input().split())
    x.append(a)
    h.append(b)
near = x[0]
if n == 1:
    print(1)
else:
    for i in range(1,n-1):
        if x[i] - near > h[i]:
            num += 1
            near = x[i]
            continue
        if x[i+1] - x[i] > h[i]:
            num += 1
            near = x[i] + h[i]
            continue
        near = x[i]
    print(num)
