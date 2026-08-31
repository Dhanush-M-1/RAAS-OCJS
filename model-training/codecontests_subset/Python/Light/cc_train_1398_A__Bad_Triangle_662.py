def solve(arr):
    
    n = len(arr)
  
    if arr[0] + arr[1] <= arr[-1]:
        return [1, 2, n]
    return -1

t = int(input())
while t:
    n = int(input())
    arr = list(map(int, input().split()))
    res = (solve(arr))
    if res == -1:
        print(-1)
    else:
        print(" ".join(list(map(str,res))))
    
    
    t -= 1