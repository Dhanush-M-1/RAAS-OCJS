from __future__ import print_function

n = int(input())
sum1, sum2, sum3 = 0, 0, 0
arr1 = [int(x) for x in input().split()]
sum1 = sum(arr1)

arr2 = [int(x) for x in input().split()]
sum2 = sum(arr2)

arr3 = [int(x) for x in input().split()]
sum3 = sum(arr3)


print(sum1 - sum2, sum2 - sum3, sep='\n')