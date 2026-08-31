n = int(input())
arr = list(map(int,input().split()))

arr1 = list(map(int,input().split()))

arr2 = list(map(int,input().split()))
a = 0
b = 0
for i in range(n):
    a^=arr[i]
for i in range(n-1):
    a^=arr1[i]
    b^=arr1[i]
for i in range(n-2):
    b^=arr2[i]
print(a)
print(b)