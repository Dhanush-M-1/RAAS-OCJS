n=int(input())
d=[[0,0] for i in range(n)]

for i in range(n):
    d[i][0],d[i][1]=list(map(int,input().split()))

d[0][0],d[0][1]=d[0][0]-d[0][1],d[0][0]
count=1
if(n==1):
    print(count)
else:
    d[-1][1]=d[-1][0]+d[-1][1]
    count+=1
    
    for i in range(1,n-1):
        right=d[i][0]+d[i][1]
        left=d[i][0]-d[i][1]
        right_possible=0
        left_possible=0
        
        if(right<d[i+1][0]):
            right_possible=1
        if(left>d[i-1][1]):
            left_possible=1
        if(left_possible==0 and right_possible==0):
            d[i][1]=d[i][0]
        elif(left_possible):
            d[i][1]=d[i][0]
            d[i][0]=left
            count+=1
        else:
            d[i][1]=right
            count+=1
    print(count)

