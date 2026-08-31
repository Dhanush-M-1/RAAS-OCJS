t = int(input())
for _ in range(t):
    size = int(input())
    arr = [int(x) for x in input().split()]
    assert len(arr) == size
    if size == 1:
        print("Yes")
        continue
    if size == 2:
        if arr[0] == 0 and arr[1] != 0:
            print("Yes")
        elif arr[1] == 0 and arr[0] != 0:
            print("Yes")
        elif arr[0] == 0 and arr[1] == 0:
            print("No")
        else:
            print("Yes")
        continue
    # zero_count = 0
    # for x in arr:
    #     if x == 0:
    #         zero_count += 1
    # if zero_count == 0:
    #     print("Yes")
    #     continue
    # if zero_count > 2:
    #     print("No")
    #     continue
    # if zero_count == 1:
    #     if arr[0] == 0 or arr[-1] == 0:
    #         print("Yes")
    #     else:
    #         print("No")
    #     continue
    # if arr[0] == 0 and arr[-1] == 0:
    #     print("Yes")
    # else:
    #     print("No")
    if size % 2 == 0:
        # In case of even, there are two possible smallest numbers
        # So, the input should be atleast one of the below
        #  * 0 1 2 3 1 0
        #  * 0 1 3 2 1 0
        largest = size // 2
        max_arr = list(range(0, largest+1)) + list(range(size - largest - 2 ,-1,-1))
        sharpened = True
        for i in range(size):
            if arr[i] < max_arr[i]:
                sharpened = False
                break
        if sharpened:
            print("Yes")
            continue
        max_arr.reverse()
        sharpened = True
        for i in range(size):
            if arr[i] < max_arr[i]:
                sharpened = False
                break
        if sharpened:
            print("Yes")
        else:
            print("No")
    else:
        largest = size // 2
        max_arr = list(range(0, largest+1)) + list(range(size - largest - 2, -1, -1))
        sharpened = True
        for i in range(size):
            if arr[i] < max_arr[i]:
                sharpened = False
                break
        if sharpened:
            print("Yes")
        else:
            print("No")