for _ in range(int(input())):
    n = int(input())
    arr = list(map(int,input().split()))
    mn = float('inf')
    mx = 0
    diff = 0
    k = None
    for i in range(n-1):
        if arr[i] !=-1 and arr[i+1] != -1:
            diff = max(diff, abs(arr[i+1]-arr[i]))
        elif arr[i] == -1 and arr[i+1]==-1:
            continue
        elif arr[i]==-1:
            mx = max(mx, arr[i+1])
            mn = min(mn, arr[i+1])
        else:
            mx = max(mx, arr[i])
            mn = min(mn, arr[i])
    
    if mn == float('inf'):
        print( f"0 42" )
    else:
        k = (mn + mx)//2
        print( f"{max( abs(k-mn), abs(k-mx), diff )} {k}" )