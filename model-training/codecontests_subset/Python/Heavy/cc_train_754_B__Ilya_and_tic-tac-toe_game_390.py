a = [[0 for i in range(4)]for j in range(4)]
for i in range(4):
    m = list(input())
    for j in range(len(m)):
        a[i][j] = m[j]

for i in range(4):
    for j in range(4):
        if(a[i][j] == '.'):
            a[i][j] = 'x'
            if(a[i][0]=='x' and a[i][1]=='x' and  a[i][2]=='x'):
                print("YES")
                exit()
            if (a[i][1] == 'x' and a[i][2] == 'x' and a[i][3] == 'x'):
                print("YES")
                exit()
            if (a[0][j] == 'x' and a[1][j] == 'x' and a[2][j] == 'x'):
                print("YES")
                exit()
            if (a[1][j] == 'x' and a[2][j] == 'x' and a[3][j] == 'x'):
                print("YES")
                exit()
            if(i<=1 and j<=1):
                if(a[i][j] == 'x' and  a[i+1][j+1]=='x' and a[i+2][j+2]=='x'):
                    print("YES")
                    exit()
            if(i<=1 and j>=2):
                if (a[i][j] == 'x' and a[i + 1][j - 1] == 'x' and a[i + 2][j - 2] == 'x'):
                    print("YES")
                    exit()
            if(i>=2 and j<=1):
                if (a[i][j] == 'x' and a[i - 1][j + 1] == 'x' and a[i - 2][j + 2] == 'x'):
                    print("YES")
                    exit()
            if(i>=2 and j>=2):
                if (a[i][j] == 'x' and a[i - 1][j - 1] == 'x' and a[i - 2][j - 2] == 'x'):
                    print("YES")
                    exit()
            if((i==1 or i==2) and (j==1)):
                if (a[i][j] == 'x' and a[i - 1][j - 1] == 'x' and a[i + 1][j + 1] == 'x'):
                    print("YES")
                    exit()
                if (a[i][j] == 'x' and a[i - 1][j + 1] == 'x' and a[i + 1][j - 1] == 'x'):
                    print("YES")
                    exit()
            if ((i == 1 or i == 2) and (j == 2)):
                if (a[i][j] == 'x' and a[i - 1][j + 1] == 'x' and a[i + 1][j - 1] == 'x'):
                    print("YES")
                    exit()
                if (a[i][j] == 'x' and a[i - 1][j - 1] == 'x' and a[i + 1][j + 1] == 'x'):
                    print("YES")
                    exit()
            a[i][j]='.'

print("NO")







