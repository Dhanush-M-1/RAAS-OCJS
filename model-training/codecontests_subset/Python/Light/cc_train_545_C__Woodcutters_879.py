n = int(input())
x = []
h = []
for i in range(n):
    a, b = map(int, input().split())
    x.append(a)
    h.append(b)
count = 1
for i in range(1, n):
    if x[i]-h[i]>x[i-1]:
        count+=1
    elif i == n-1:
        count+=1
    elif x[i]+h[i]<x[i+1]:
        count+=1
        x[i] = x[i]+h[i]
print(count)