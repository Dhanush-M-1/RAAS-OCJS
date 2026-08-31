n=int(input())
arr=list(map(int,input().split()))
seq=list(map(int,input().split()))
don=list(map(int,input().split()))
sum1=sum2=sum3=0
for i in arr:
    sum1+=i
for i in seq:
    sum2+=i
for i in don:
    sum3+=i
print(sum1-sum2)
print(sum2-sum3)