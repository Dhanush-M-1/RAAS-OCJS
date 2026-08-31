arr = []
c = False
for i in range(0, 4):
    arr.append(input())
for i in range(0,4):
    if arr[i][0] == 'x' and arr[i][1] == 'x' and arr[i][2] == '.':
        c=True
    elif arr[i][1] == 'x' and arr[i][2] == 'x' and arr[i][0] == '.':
        c=True
    elif arr[i][1] == '.' and arr[i][2] == 'x' and arr[i][0] == 'x':
        c=True
        
    elif arr[i][1] == 'x' and arr[i][2] == 'x' and arr[i][3] == '.':
        c=True
    elif arr[i][2] == 'x' and arr[i][3] == 'x' and arr[i][1] == '.':
        c=True
    elif arr[i][2] == '.' and arr[i][3] == 'x' and arr[i][1] == 'x':
        c=True
    


for i in range(0,4):
    if arr[0][i] == 'x' and arr[1][i] == 'x' and arr[2][i] == '.':
        c=True
    elif arr[1][i] == 'x' and arr[2][i] == 'x' and arr[0][i] == '.':
        c=True
    elif arr[1][i] == '.' and arr[2][i] == 'x' and arr[0][i] == 'x':
        c=True
        
    elif arr[1][i] == 'x' and arr[2][i] == 'x' and arr[3][i] == '.':
        c=True
    elif arr[2][i] == 'x' and arr[3][i] == 'x' and arr[1][i] == '.':
        c=True
    elif arr[2][i] == '.' and arr[3][i] == 'x' and arr[1][i] == 'x':
        c=True
    
        
if arr[2][0] == 'x' and arr[1][1] == 'x' and arr[0][2] == '.':
    c=True
elif arr[2][0] == '.' and arr[1][1] == 'x' and arr[0][2] == 'x':
    c=True
elif arr[2][0] == 'x' and arr[1][1] == '.' and arr[0][2] == 'x':
    c=True
    
elif arr[3][1] == 'x' and arr[2][2] == 'x' and arr[1][3] == '.':
    c=True
elif arr[3][1] == '.' and arr[2][2] == 'x' and arr[1][3] == 'x':
    c=True
elif arr[3][1] == 'x' and arr[2][2] == '.' and arr[1][3] == 'x':
    c=True
    
elif arr[1][0] == 'x' and arr[2][1] == 'x' and arr[3][2] == '.':
    c=True
elif arr[1][0] == '.' and arr[2][1] == 'x' and arr[3][2] == 'x':
    c=True
elif arr[1][0] == 'x' and arr[2][1] == '.' and arr[3][2] == 'x':
    c=True
    
elif arr[0][1] == 'x' and arr[1][2] == 'x' and arr[2][3] == '.':
    c=True
elif arr[0][1] == '.' and arr[1][2] == 'x' and arr[2][3] == 'x':
    c=True
elif arr[0][1] == 'x' and arr[1][2] == '.' and arr[2][3] == 'x':
    c=True
    
elif arr[0][0] == 'x' and arr[1][1] == 'x' and arr[2][2] == '.':
    c=True
elif arr[0][0] == '.' and arr[1][1] == 'x' and arr[2][2] == 'x':
    c=True
elif arr[0][0] == 'x' and arr[1][1] == '.' and arr[2][2] == 'x':
    c=True
    
elif arr[1][1] == 'x' and arr[2][2] == 'x' and arr[3][3] == '.':
    c=True
elif arr[1][1] == '.' and arr[2][2] == 'x' and arr[3][3] == 'x':
    c=True
elif arr[1][1] == 'x' and arr[2][2] == '.' and arr[3][3] == 'x':
    c=True
    
elif arr[3][0] == 'x' and arr[2][1] == 'x' and arr[1][2] == '.':
    c=True
elif arr[3][0] == '.' and arr[2][1] == 'x' and arr[1][2] == 'x':
    c=True
elif arr[3][0] == 'x' and arr[2][1] == '.' and arr[1][2] == 'x':
    c=True

 
elif arr[2][1] == 'x' and arr[1][2] == 'x' and arr[0][3] == '.':
    c=True
elif arr[2][1] == '.' and arr[1][2] == 'x' and arr[0][3] == 'x':
    c=True
elif arr[2][1] == 'x' and arr[1][2] == '.' and arr[0][3] == 'x':
    c=True

if c == False:
    print('NO')
else:
    print('YES')









    
