n = int(input())

if n == 1:
    print(1)
else:
    pos = []
    heights = []
    for i in range(0, n):
        a = list(map(int,input().split()))
        pos.append(a[0])
        heights.append(a[1])
        
    count = 2
    
    for i in range(1,n-1):
        if pos[i] - heights[i] > pos[i-1]:
            count = count + 1
            
        elif pos[i] + heights[i] < pos[i+1]:
            count = count + 1
            pos[i] = pos[i] + heights[i]
            
            
    print(count)
