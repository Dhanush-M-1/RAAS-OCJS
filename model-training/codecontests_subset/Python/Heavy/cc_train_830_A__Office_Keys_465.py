n,k,p = map(int,input().split())
a = []
b = []
temp = input().split()
for i in range(n):
    a.append(int(temp[i]))
temp = input().split()
for i in range(k):
    b.append(int(temp[i]))
list.sort(a)
list.sort(b)
mini = 0
for i in range(k-n+1):
    maxi = 0
    cur = 0
    for j in range(n):
        if p >= a[j]:
            if a[j] > b[i+j]:
                cur = p+a[j]-2*b[i+j]
            elif b[i+j] > p:
                cur = 2*b[i+j]-p-a[j]
            else:
                cur = p-a[j]
        else:
            if b[i+j] > a[j]:
                cur = 2*b[i+j]-p-a[j]
            elif b[i+j] < p:
                cur = p+a[j]-2*b[i+j]
            else:
                cur = a[j]-p
        if cur > maxi:
            maxi = cur
    if maxi < mini or i == 0:
        mini = maxi
print(mini)
