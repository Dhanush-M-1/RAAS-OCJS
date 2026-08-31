a=[int(q) for q in input().strip().split()]
b=[int(q) for q in input().strip().split()]
min=200
for k in range(a[0]):
    if a[1]%b[k]==0:
        if a[1]/b[k]<min:
            min=a[1]/b[k]
print(int(min))