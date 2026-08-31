[n, k] = [int(x) for x in input().split()]
A = [int(x) for x in input().split()]
m=101
for i in range(n):
    if k%A[i]==0:
        if k//A[i]<m:
            m=k//A[i]
    i+=1
print(m)


