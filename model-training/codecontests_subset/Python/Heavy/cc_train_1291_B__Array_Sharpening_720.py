tc = int(input())
for _ in range(tc):
    n = int(input())
    arr = list(map(int, input().split()))
    right = []
    left_False = float("inf")
    right_False = float("-inf")
    for i in range(n):
        if not arr[i] >= i:
            left_False = i
            break

    for i in range(n)[::-1]:
        if not arr[i] >= (n-i-1):
            right_False = i
            break

    if left_False > right_False:
        if (left_False == right_False + 1):
            if(arr[left_False] > arr[right_False]):
                print("Yes")
            else:
                print("No")
        else:
            print("Yes")
    else:
        print("No")
