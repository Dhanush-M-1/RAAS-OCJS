n,k = [int(i) for i in input().split()]
a = [int(i) for i in input().split()]
m = 100000000000
for i in range (n):
    if k%a[i]==0 and k//a[i] < m:
        m = k//a[i]
print (m)
    