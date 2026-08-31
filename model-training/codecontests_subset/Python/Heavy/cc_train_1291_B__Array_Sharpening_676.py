
def can_sharpen(n,arr):
    is_raising = True
    for i,a in enumerate(arr):
        if is_raising:
            if i > a:
                is_raising = False
                if a < n-1-i or arr[i-1] < (n-1-i) + 1:
                #if a < min(arr[i-1],n-1-i):
                    return False
        else:
            if a < n-1-i:
                return False
    return True

t = int(input())
for _ in range(t):
    n = int(input())
    arr = list(map(int,input().split()))
    if can_sharpen(n,arr):
        print('Yes')
    else:
        print('No')
