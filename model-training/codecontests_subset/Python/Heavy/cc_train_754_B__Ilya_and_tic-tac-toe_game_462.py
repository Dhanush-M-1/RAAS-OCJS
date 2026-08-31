M=[['o','o','o','o','o','o','o','o'] for i in range(8)]
M1=[input() for i in range(4)]
c='NO'
for i in range(4) :
    for j in range(4) :
        M[i+2][j+2]=M1[i][j]
for i in range(2,6) :
    for j in range(2,6) :
        if M[i][j]=='x' :
            if M[i+1][j]=='x' and M[i+2][j]=='x' or M[i+1][j]=='.' and M[i+2][j]=='x' or M[i+1][j]=='x' and M[i+2][j]=='.' :
                c='YES'
            if M[i-1][j]=='x' and M[i-2][j]=='x' or M[i-1][j]=='.' and M[i-2][j]=='x' or M[i-1][j]=='x' and M[i-2][j]=='.' :
                c='YES'
            if M[i][j+1]=='x' and M[i][j+2]=='x' or M[i][j+1]=='.' and M[i][j+2]=='x' or M[i][j+1]=='x' and M[i][j+2]=='.' :
                c='YES'
            if M[i][j-1]=='x' and M[i][j-2]=='x' or M[i][j-1]=='.' and M[i][j-2]=='x' or M[i][j-1]=='x' and M[i][j-2]=='.' :
                c='YES'
            if M[i+1][j+1]=='x' and M[i+2][j+2]=='x' or M[i+1][j+1]=='.' and M[i+2][j+2]=='x' or M[i+1][j+1]=='x' and M[i+2][j+2]=='.' :
                c='YES'
            if M[i-1][j-1]=='x' and M[i-2][j-2]=='x' or M[i-1][j-1]=='.' and M[i-2][j-2]=='x' or M[i-1][j-1]=='x' and M[i-2][j-2]=='.' :
                c='YES'
            if M[i+1][j-1]=='x' and M[i+2][j-2]=='x' or M[i+1][j-1]=='.' and M[i+2][j-2]=='x' or M[i+1][j-1]=='x' and M[i+2][j-2]=='.' :
                c='YES'
            if M[i-1][j+1]=='x' and M[i-2][j+2]=='x' or M[i-1][j+1]=='.' and M[i-2][j+2]=='x' or M[i-1][j+1]=='x' and M[i-2][j+2]=='.' :
                c='YES'
print(c)
            
            
            
