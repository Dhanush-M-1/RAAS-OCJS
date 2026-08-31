n=int(input())
l=list(map(int,input().split()))
l2=list(map(int,input().split()))
l3=list(map(int,input().split()))
sum=sum2=sum3=0
for i in l:
    sum+=i
for i in l2:
    sum2+=i
for i in l3:
    sum3+=i
print(sum-sum2)
print(sum2-sum3)