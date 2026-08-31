def check(i,j):
    #left
    if j-2 in range(4):
        if field[i][j-2] == 1 and field[i][j-1] == 1:
            return True
    #right
    if j+2 in range(4):
        if field[i][j+1] == 1 and field[i][j+2] == 1:
            return True
    #up
    if i+2 in range(4):
        if field[i+1][j] == 1 and field[i+2][j] == 1:
            return True 
    #down
    if i-2 in range(4):
        if field[i-1][j] == 1 and field[i-2][j] == 1:
            return True  
    #hor right down
    if (i+1 in range(4)) and (i+2 in range(4)) and (j+1 in range(4)) and (j+2 in range(4)):
        if field[i+1][j+1] == 1 and field[i+2][j+2] == 1:
            return True
    
    #hor left up
    if (i-1 in range(4)) and (i-2 in range(4)) and (j-1 in range(4)) and (j-2 in range(4)):
        if field[i-1][j-1] == 1 and field[i-2][j-2] == 1:
            return True 
    
    #hor left down
    if (i+1 in range(4)) and (i+2 in range(4)) and (j-1 in range(4)) and (j-2 in range(4)):
        if field[i+1][j-1] == 1 and field[i+2][j-2] == 1:
            return True  
        
    #hor right up
    if (i-1 in range(4)) and (i-2 in range(4)) and (j+1 in range(4)) and (j+2 in range(4)):
        if field[i-1][j+1] == 1 and field[i-2][j+2] == 1:
            return True 
        
    #midhoriz
    if j-1 in range(4) and j+1 in range(4):
        if field[i][j-1] == 1 and field[i][j+1] == 1:
            return True
    
    #midvert
    if i-1 in range(4) and i+1 in range(4):
        if field[i-1][j] == 1 and field[i+1][j] == 1:
            return True
    
    #mid horiz 2
    if i-1 in range(4) and j-1 in range(4) and i+1 in range(4) and j+1 in range(4):
        if (field[i-1][j-1] == 1 and field[i+1][j+1] == 1) or (field[i-1][j+1] == 1 and field[i+1][j-1] == 1) :
            return True    
    
    return False

field = [[0,0,0,0], 
         [0,0,0,0], 
         [0,0,0,0],
         [0,0,0,0]]

for i in range(4):
    j = 0
    for x in input():
        if x == "x":
            tmp = 1
        elif x == "o":
            tmp = 2
        else:
            tmp = 0
        field[i][j] = tmp
        j += 1
yes = False    
for i in range(4):
    for j in range(4):
        if field[i][j] == 0:
            if check(i,j):
                print("YES")
                yes = True
                break
    if yes:
        break
if not(yes):
    print("NO")
            
    