n, k = [int(x) for x in input().split()]
arr = [int(x) for x in input().split()]

print(min([k//a for a in arr if k % a == 0]))