# You
# Dont read my code
n = int(input())
array_1 = [ i for i in map(int,input().split()) ]
array_2 = [ i for i in map(int,input().split()) ]
array_3 = [ i for i in map(int,input().split()) ]
#--------------------------
sum1 = 0
for i in array_1:
    sum1 += i
sum2 = 0
for i in array_2:
    sum2 += i
sum3 = 0
for i in array_3:
    sum3 += i
#--------------------------
print(sum1 - sum2)
print(sum2 - sum3)
