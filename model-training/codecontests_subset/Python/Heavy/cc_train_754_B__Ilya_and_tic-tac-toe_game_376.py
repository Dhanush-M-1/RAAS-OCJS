c =  []
for i in range(4):
    s = input()
    c.append([])
    for j in range(4):
        c[i].append(s[j])
        

ans = "NO"
for i in range(4):
    for j in range(4):
        if c[i][j]=='.':
            q = c[i][j]
            c[i][j]='x'
            for k in range(4):
                if c[k][0]==c[k][1] and c[k][0]==c[k][2] and c[k][0]=='x':
                    ans = "YES"
                if c[k][1]==c[k][2] and c[k][1]==c[k][3] and c[k][3]=='x':
                    ans = "YES"
            for k in range(4):
                if c[0][k]==c[1][k] and c[0][k]==c[2][k] and c[2][k]=='x':
                    ans = "YES"
                if c[1][k]==c[2][k] and c[1][k]==c[3][k] and c[3][k]=='x':
                    ans = "YES"        
            if c[0][0]==c[1][1] and c[0][0]==c[2][2] and c[0][0]=='x':
                ans = "YES"
            if c[2][2]==c[1][1] and c[1][1]==c[3][3] and  c[2][2]=='x':
                ans = "YES"
            if c[0][1]==c[1][2] and c[0][1]==c[2][3] and c[0][1]=='x':
                ans = "YES"
            if c[1][0]==c[2][1] and c[1][0]==c[3][2] and c[1][0]=='x':
                ans = "YES"
            
            if c[0][3]==c[1][2] and c[0][3]==c[2][1] and c[0][3]=='x':
                ans = "YES"
            if c[3][0]==c[2][1] and c[3][0]==c[1][2] and c[1][2]=='x':
                ans = "YES"
            if c[2][0]==c[1][1] and c[2][0]==c[0][2] and c[0][2]=='x':
                ans = "YES"
            if c[3][1]==c[2][2] and c[3][1]==c[1][3] and c[1][3]=='x':
                ans = "YES"
            c[i][j]=q
            
            
print(ans)