t = int(input())

for _ in range(t):
    n = int(input())
    a = list(map(int, input().strip().split()))
    left = [0 for _ in range(len(a))]
    right = [0 for _ in range(len(a))]
    for i in range(len(a)):
        if a[i] >= i:
            left[i] = 1
        else:
            break
    for i in range(len(a) - 1, -1, -1):
        if a[i] >= len(a) - i - 1:
            right[i] = 1
        else:
            break
    good = False
    for i in range(len(a)):
        if left[i] == right[i] and left[i] == 1:
            print("Yes")
            good = True
            break
    if not good:
        print("No")