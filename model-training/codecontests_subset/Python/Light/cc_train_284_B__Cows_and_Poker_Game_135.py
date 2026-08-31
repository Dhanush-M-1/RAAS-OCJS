n = int(input())
arr = input()
if arr.count('I') > 1:
    print(0)
elif arr.count('I') == 1:
    print(1)
else:
    print(arr.count('A'))