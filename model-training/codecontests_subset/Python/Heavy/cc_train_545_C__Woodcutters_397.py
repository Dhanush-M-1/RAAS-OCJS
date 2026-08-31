import sys
n = int(sys.stdin.readline())
leftStart = int(sys.stdin.readline().split()[0])
ans = 1
points = []
if n>1:
    for i in range(1,n):
        inp = str(sys.stdin.readline())[:-1].split()
        points.append(inp)
    
    ans+=1
    endPoint = int(inp[-1][0])
    leftPoint = leftStart
    for i in range(n-2):
        x = int(points[i][0])
        h = int(points[i][1])
        tmpX = x-h        
        #print(tmpX,leftPoint)
        if tmpX>leftPoint:
            ans += 1
            leftPoint = x
        else:
            tmpX = x+h
            if tmpX<int(points[i+1][0]):
                leftPoint = tmpX
                ans+=1
            else:
                leftPoint = x

print(ans)
