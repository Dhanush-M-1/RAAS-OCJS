def add(arr, N, lo, hi, val): 
    arr[lo] += val 
    if (hi != N - 1): 
        arr[hi + 1] -= val 
def updateArray(arr, N): 
    for i in range(1, N): 
        arr[i] += arr[i - 1] 
def printArr(arr, N): 
    updateArray(arr, N) 
    return arr
for _ in range(int(input())):
    n,m = map(int,input().split())
    s = input()
    p = list(map(int,input().split()))
    f = {}
    for i in range(97,123):
        f[i] = 0
    diff = [0 for i in range(n)]
    for i in p:
        add(diff,n,0,i-1,1)
    diff = printArr(diff, n) 
    for i in range(n):
        f[ord(s[i])]+=diff[i]+1
    #print(f)
    for i in range(97,123):
        if (i) in f:
            print(f[(i)], end = " ")
        else:
            print(0, end = " ")
    print()

        
    
"""
"""