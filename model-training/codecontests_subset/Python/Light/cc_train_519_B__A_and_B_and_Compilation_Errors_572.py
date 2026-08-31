import os
n = int(input())
list1 = input().split(" ")
list2 = input().split(" ")
list3 = input().split(" ")

sum1 = 0
sum2 = 0
sum3 = 0

for i in range(0,n):
    x = int(list1[i])
    sum1 += x

for i in range(0,n - 1):
    x = int(list2[i])
    sum2 += x

for i in range (0, n - 2):
    x = int(list3[i])
    sum3 += x

print(sum1 - sum2, sum2 - sum3)
