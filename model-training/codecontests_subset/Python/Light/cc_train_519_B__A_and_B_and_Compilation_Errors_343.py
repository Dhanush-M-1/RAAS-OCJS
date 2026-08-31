
n=int(input())

errors=list(int(x) for x in input().split())

errors1=list(int(x) for x in input().split())

errors2=list(int(x) for x in input().split())

sum1,sum2,sum3=0,0,0

for i in range(n-2):
    sum1+=errors[i]
    sum2+=errors1[i]
    sum3+=errors2[i]
    
sum1+=errors[-1]+errors[-2]
sum2+=errors1[-1]
#print(sum1,sum2,sum3) 
print(sum1-sum2)
print(sum2-sum3)
