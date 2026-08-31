def get_triplet(arr):
    return [1, 2, len(arr)] if arr[0] + arr[1] <= arr[-1] else None 
    
    
for _ in range(int(input())):
    n = int(input())
    arr = list(map(int, input().split()))
    result = get_triplet(arr)
    if not result:
        print(-1)
    else:
        print(' '.join(map(str, result)))