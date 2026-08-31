x=int(input())
first=list(map(int,input().split()))
second=list(map(int,input().split()))
third=list(map(int,input().split()))

sum1=0
sum2=0
sum3=0
for i in first:
    sum1+=i
for i in second:
    sum2+=i
for i in third:
    sum3+=i
print(sum1-sum2)
print(sum2-sum3)