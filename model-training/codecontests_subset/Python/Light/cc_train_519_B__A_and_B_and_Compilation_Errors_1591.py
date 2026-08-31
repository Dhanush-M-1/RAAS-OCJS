# cook your dish here
import math
n=int(input())
arr1=list(map(int,input().rstrip().split()))
arr2=list(map(int,input().rstrip().split()))
arr3=list(map(int,input().rstrip().split()))

print(sum(arr1)-sum(arr2))
print(sum(arr2)-sum(arr3))