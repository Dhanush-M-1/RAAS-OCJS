min=101;y=0; n,k= map(int,input().split());a=[int(x) for x in input().split()]
for i in range(n):
    if k%a[i]==0:
        y=k//a[i]
        if y<min: min=y
print(min)