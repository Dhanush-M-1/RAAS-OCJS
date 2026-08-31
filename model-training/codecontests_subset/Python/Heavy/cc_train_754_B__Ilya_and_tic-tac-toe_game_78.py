def func(arr):
    for i in range(4):
        for j in range(2):
            countdot=countx=0
            if arr[i][j]=='x':
                countx += 1
            elif arr[i][j]=='.':
                countdot += 1
            if arr[i][j+1]=='x':
                countx += 1
            elif arr[i][j+1]=='.':
                countdot += 1
            if arr[i][j+2]=='x':
                countx += 1
            elif arr[i][j+2]=='.':
                countdot += 1
            if countx==2 and countdot==1:
                return True
    for i in range(2):
        for j in range(4):
            countdot=countx=0
            if arr[i][j]=='x':
                countx += 1
            elif arr[i][j]=='.':
                countdot += 1
            if arr[i+1][j]=='x':
                countx += 1
            elif arr[i+1][j]=='.':
                countdot += 1
            if arr[i+2][j]=='x':
                countx += 1
            elif arr[i+2][j]=='.':
                countdot += 1
            if countx==2 and countdot==1:
                return True
def func2(arr):
    lst = [[[0,0],[1,1],[2,2]],[[0,1],[1,2],[2,3]],[[0,2],[1,1],[2,0]],[[0,3],[1,2],[2,1]],[[3,0],[2,1],[1,2]],[[3,1],[2,2],[1,3]],[[3,2],[2,1],[1,0]],[[3,3],[2,2],[1,1]]]
    for i in lst:
        countdot=countx=0
        for j,k in i:
            if arr[j][k]=='x':
                countx += 1
            elif arr[j][k]=='.':
                countdot += 1
        if countdot==1 and countx==2:
            return True
arr = []
for i in range(4):
    t = input()
    arr.append(t)
if func(arr):
    print('YES')
elif func2(arr):
    print('YES')
else:
    print('NO')