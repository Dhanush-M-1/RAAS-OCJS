n=int(input())
a=[0]*n
ma=-1
a=[int (j) for j in input().split()]

for i in range(n):
    t=1000000-a[i]
    if t>(a[i]-1):
        t=a[i]-1
    if t>ma:
        ma=t
print(ma)
