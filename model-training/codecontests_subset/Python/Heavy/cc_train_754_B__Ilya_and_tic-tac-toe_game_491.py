s=[]
response='NO'
for _ in range(4):
    s=s+[input()]
wins=['xx.','x.x','.xx','xxx']
for i in range(4):
    if s[i][1:] in wins or s[i][:3] in wins:
        response='YES'
    if i>1:
        for j in range(4):
            if s[i-2][j]+s[i-1][j]+s[i][j] in wins:
                response='YES'    
for i in range(1,3):
    for j in range(1,3):
        if s[i-1][j-1]+s[i][j]+s[i+1][j+1] in wins or s[i-1][j+1]+s[i][j]+s[i+1][j-1] in wins or s[i-1][j+1]+s[i][j]+s[i+1][j-1] in wins:
            response='YES'
print(response)