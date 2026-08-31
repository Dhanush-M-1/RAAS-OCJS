n=int(input())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
c=list(map(int,input().split()))
sum_a=0;sum_b=0;sum_c=0
for i in range(n):sum_a+=a[i]
for i in range(n-1):sum_b+=b[i]
for i in range(n-2):sum_c+=c[i]
print(sum_a-sum_b)
print(sum_b-sum_c)