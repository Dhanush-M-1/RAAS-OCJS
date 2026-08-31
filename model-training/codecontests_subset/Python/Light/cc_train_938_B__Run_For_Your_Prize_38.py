n=int(input())
a=list(map(int,input().split(' ')))
max=0
min=10**7
for i in range(len(a)):
    if a[i]>500000:
        if a[i]<min:
            min=a[i]
    else:
        if a[i]>max:
            max=a[i]
b=max-1
c=10**6-min
if b>c:
    print(b)
else:
    print(c)
    
