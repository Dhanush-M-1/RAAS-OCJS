n = input()
arr = list(map(int,input().split()))
arr1=list(map(int,input().split()))
arr2=list(map(int,input().split()))
sum_all=0
sum_1=0
sum_2=0
for i in arr:
    sum_all+=i
for i in arr1:
    sum_1+=i
for i in arr2:
    sum_2+=i
print(sum_all-sum_1)
print(sum_1-sum_2)
