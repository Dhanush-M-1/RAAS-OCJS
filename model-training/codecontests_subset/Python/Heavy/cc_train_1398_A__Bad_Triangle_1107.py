for t in range(int(input())):
    n = int(input())
    nums = list(map(int,input().split()))
    a = sorted(nums)
    a1 = 0
    a2 = 0
    a3 = 0
    if (a[0] + a[1] <= a[n-1]):
        c = 0
        for i in range(n):
            if (nums[i] == a[0] and a1 == 0):
                a1 = 1
                c += 1
                print(i+1,end=" ")
            elif (nums[i] == a[1] and a2 == 0):
                a2 = 1
                c += 1
                print(i + 1, end=" ")
            elif (nums[i] == a[n-1] and a3 == 0):
                a3 = 1
                c += 1
                print(i + 1, end=" ")
            if (c == 3):
                print()
                break
    else:
        print("-1")

