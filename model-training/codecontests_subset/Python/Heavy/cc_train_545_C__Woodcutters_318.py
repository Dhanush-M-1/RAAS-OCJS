n = int(input())
coord = []
heights = []
for i in range(n):
    c, h = map(int, input().split())
    coord.append(c)
    heights.append(h)

if n==1:
    print(1)
else:
    fall = [0] * (n-2)
    fall = [-1] + fall
    fall = fall + [1]

    for i in range(1,n-1):
        if fall[i-1] == -1 or fall[i-1] == 0:
            if heights[i] < coord[i] - coord[i-1]:
                fall[i]=-1
            elif heights[i] < coord[i+1] - coord[i]:
                fall[i]=1
            else:
                fall[i]=0
                    
        else:
            if heights[i-1] + heights[i] < coord[i] - coord[i-1]:
                fall[i]=-1
            elif heights[i] < coord[i+1] - coord[i]:
                fall[i]=1
            else:
                fall[i]=0
    count=0
    for i in fall:
        if i!=0:
            count+=1
    print(count)