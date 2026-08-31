n = int(input())
sum = 0
sum_2 = 0

for i in input().split():
    sum +=int(i)
    
for i in input().split():
    sum_2 +=int(i)
    
print(sum - sum_2)
sum -=(sum - sum_2)
sum_2 = 0

for i in input().split():
    sum_2 +=int(i)
print(sum - sum_2)