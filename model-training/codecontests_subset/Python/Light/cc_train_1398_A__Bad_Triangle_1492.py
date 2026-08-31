for _ in range(int(input())):
    n=int(input())
    l=list(map(int,input().split()))

    def bin_search(data, target):  # order of log(n)   # works only on sorted list
        low = 0
        high = len(data) - 1

        while low <= high:
            mid = (low + high) // 2
            if data[mid] >= target:
                return mid
            elif data[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
    for i in range(n-2):
        a=bin_search(l,l[i]+l[i+1])
        if a!=-1:
            print(i+1,i+2,a+1)
            break
    else:
        print(-1)
