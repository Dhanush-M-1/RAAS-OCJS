n = int(input())
line1=input().split()
line2=input().split()
line3=input().split()
result1 = 0
result2 = 0
sum1=0
sum2=0
sum3=0
for i in line1:
    sum1+=int(i)
for i in line2:
    sum2+=int(i)
for i in line3:
    sum3+=int(i)
print(sum1-sum2)
print(sum2-sum3)
