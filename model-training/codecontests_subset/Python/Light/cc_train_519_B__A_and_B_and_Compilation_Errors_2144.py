n=int(input())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
c=list(map(int,input().split()))
m=n-1
t=m-1
sum1,sum2,sum3=0,0,0
for i in range(n):
    sum1+=a[i]
for i in range(m):
    sum2+=b[i]    
for i in range(t):
    sum3+=c[i]    
print(sum1-sum2)
print(sum2-sum3)