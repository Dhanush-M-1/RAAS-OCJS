from cmath import nan
from audioop import avg
def mad(x):
    m = 0
    for i in range(len(x)-1):
        m = max(m, abs(x[i]-x[i+1]))
    return m

def replace(arr, val):
    for i in range(len(arr)):
        if arr[i] == -1:
            arr[i] = val
        
t = int(input())
for _ in range(t):
    n = int(input())
    arr = [int(x) for x in input().split()]
    smalldiff = float('inf')
    maxdiff = 0
    for i in range(len(arr)):
        if arr[i] == -1:
            if i != 0:
                if arr[i-1] != -1:
                    smalldiff = min(smalldiff, arr[i-1])
                    maxdiff = max(maxdiff, arr[i-1])
            if i != len(arr)-1:
                if arr[i+1] != -1:
                    smalldiff = min(smalldiff, arr[i+1])
                    maxdiff = max(maxdiff, arr[i+1])
            
   
    avgdiff = (maxdiff+smalldiff)//2
#     if avgdiff == float('inf'):
    if smalldiff > 10**9:
        avgdiff = 0
#     print('avg', avgdiff, maxdiff, smalldiff)
#     print(maxdiff, smalldiff)
    arr_org = arr.copy()
    replace(arr, avgdiff)
    replace(arr_org, avgdiff+1)
#     print(arr, arr_org)
    m1, m2 = mad(arr), mad(arr_org)
    if m1 < m2:
        print(m1, avgdiff)
    else:
        print(m2, avgdiff+1)
       