import sys
read = lambda: sys.stdin.readline().strip()
    
for _ in range(int(read())):
    length = int(read())
    nums = list(map(int, read().split()))
    
    end = length - 1
    start = 0
    mid = start + 1

    a = nums[start]
    b = nums[mid]
    c = nums[end]

    # print("Ans", end=" ")
    if a + b <= c:
        print(start+1, mid+1, end+1)
    else:
        print(-1)
    