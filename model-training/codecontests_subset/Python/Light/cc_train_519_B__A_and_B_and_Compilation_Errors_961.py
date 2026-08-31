n = int(input())
arr = [int(i) for i in input().split()]
brr = [int(i) for i in input().split()]
grr = [int(i) for i in input().split()]
print(sum(arr)-sum(brr))
print(sum(brr)-sum(grr))