amount = int(input())
for i in range(amount):
    left, right, num = [int(s) for s in input().split()]
    if num < left:
        print(num)
    else:
        print(right + (num - right % num))