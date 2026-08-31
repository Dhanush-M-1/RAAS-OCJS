n = int(input())
s1 = input().split()
s2 = input().split()
s3 = input().split()
summ1 = 0
summ2 = 0
summ3 = 0
for i in s1 :
    summ1+=int(i)
for i in s2:
    summ2+=int(i)
for i in s3:
    summ3+=int(i)
print(summ1 -summ2 )
print(summ2-summ3)