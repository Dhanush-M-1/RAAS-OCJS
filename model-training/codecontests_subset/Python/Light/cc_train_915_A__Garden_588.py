n, k = [int(i) for i in input().split()]
arr = [int(i) for i in input().split()]
print(min(k//a for a in arr if k % a == 0))