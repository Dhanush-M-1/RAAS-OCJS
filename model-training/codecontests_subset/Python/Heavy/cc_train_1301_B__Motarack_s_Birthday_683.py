for _ in range(int(input())):
    n = int(input())
    array = list(map(int, input().split()))
# def lower_bound(array, x, low = 0, high = None):
#     if high == None:
#         high = len(array)
#     while(low < high):
#         mid = (low + high)//2
#         if x < array[mid]:
#             high = mid
#         else:
#             low = mid + 1
#     return low

# n = 5
# array = [-1, 40, 35, -1, 35]
    this = []
    i = 0
    for i in range(n):
        if array[i] == -1:
            continue
        if i - 1 >= 0:
            if array[i-1] == -1:
                this.append(array[i])
                continue
        if i + 1 < n:
            if array[i+1] == -1:
                this.append(array[i])
                continue
    this = list(set(this))
    # this.sort()
    # prefix = []
    # sumo = 0
    # for i in this:
    #     sumo += i
    #     prefix.append(sumo)

    # low = this[0]; high = this[-1] + 1;
    # ans = prefix[-1] + 1
    # while(low < high):
    #     mid = (low+high)//2
    #     ans[>mid]
    #     if ans > mid:
    #         high = mid
    #     else:
    #         low = mid + 1
#     print(this)
    if len(this) == 0:
        print(*[0, 5])
        continue
    ans = (min(this)+max(this))//2
    sumo = -1
    for i in range(n-1):
        if array[i] == -1:
            array[i] = ans
        if array[i+1] == -1:
            array[i+1] = ans
        sumo = max(sumo, abs(array[i]-array[i+1]))
    print(*[sumo , ans])