t = int(input())
for _ in range(t):
    n = int(input())
    arr = list(map(int, input().split()))

    left = True
    right = True
    end = False
    for indx, num in enumerate(arr):
        if left and right:
            if indx - num <= 0:
                left = True
            else:
                left = False
            if indx + num >= len(arr) - 1:
                right = True
            else:
                right = False

            if (not left) and (not right):
                end = True
                break

        elif left:
            if indx - num <= 0:
                left = True
            else:
                left = False
                end = True
                break
            if indx + num >= len(arr) - 1:
                right = True
            else:
                right = False
        elif right:
            if indx - num <= 0:
                left = True
            else:
                left = False
            if indx + num >= len(arr) - 1:
                right = True
            else:
                right = False
                end = True
                break
    if end:
        print("No")
    else:
        print("Yes")


