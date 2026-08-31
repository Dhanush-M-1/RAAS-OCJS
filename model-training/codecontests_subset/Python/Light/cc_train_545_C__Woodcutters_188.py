n = int(input())

x = []
h = []

for i in range(n):
    a,b = map(int , input().split())
    x.append(a)
    h.append(b)

# a = -10**10
b = -10**10
count = 0
for i in range(n):
    l = x[i] - h[i]
    if i == n-1:
        count+=1
        break
    if l>b:
        count+=1
        # a = l
        b = x[i]
    else:
        if i+1<n and x[i+1] > x[i] + h[i]:
            count+=1
            # a = x[i]
            b = x[i] + h[i]
        else:
            b = x[i]
    # print(i,b)
print(count)