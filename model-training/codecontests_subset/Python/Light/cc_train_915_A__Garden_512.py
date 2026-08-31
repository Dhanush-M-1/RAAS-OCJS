n,k=[int(i) for i in input().split()]
a=[int(i) for i in input().split()]
k_a=[]
for i in range(n):
    if k%a[i]==0:
        k_a.append(k/a[i])
print(int(min(k_a)))
        
