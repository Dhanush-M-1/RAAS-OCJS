n=int(input())
dic1={}
dic2={}
l1=list(map(int,input().split()))
l2=list(map(int,input().split()))
l3=list(map(int,input().split()))

sum1=sum(l1)
sum2=sum(l2)
sum3=sum(l3)

print(sum1-sum2)
print(sum2-sum3)
