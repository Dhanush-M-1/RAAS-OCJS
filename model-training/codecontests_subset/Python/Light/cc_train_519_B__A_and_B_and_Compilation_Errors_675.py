n = int(input())
arr = [int(i) for i in input().split()]
cmp1 = [int(i) for i in input().split()]
cmp2 = [int(i) for i in input().split()]

stor = sum(cmp1)

print(sum(arr)-stor)
print(stor-sum(cmp2))