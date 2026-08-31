n, s = map(int, input().split())

arr = list(map(int, input().split()))

a_max = len([1 for i in arr if i > s])
a_min = len(arr)-a_max


import heapq




count = 0
if a_min > a_max:
    b_min = heapq.nsmallest(a_min, arr)
    b_min.sort(reverse = True)
    for i in range(a_min - len(arr)//2):
        count += s - b_min[i]
    print(count)
else:
    b_max = heapq.nlargest(a_max, arr)
    b_max.sort()
    for i in range(a_max - len(arr)//2):
        count += b_max[i] - s
    print(count)
    
    
    
    
