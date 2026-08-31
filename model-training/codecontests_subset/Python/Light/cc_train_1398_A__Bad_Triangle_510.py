def Solution(arr):
    if not arr[0] + arr[1] > arr[-1]: 
        return str(1) + ' ' + str(2) + ' ' + str(len(arr))
    else:
        return -1          

t = int(input())

for _ in range(t):
    __ = input()
    arr = list(map(int, input().split(' ')))
    
    print(Solution(arr))