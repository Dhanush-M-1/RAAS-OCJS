def proof (array):
    answer = False
    for i in range (4):
        for j in range (2):
            if ("x" == array[i][j] == array[i][j + 1] == array[i][j + 2]):
                answer = True
                
    for i in range (4):
        for j in range (2, 4):
            if ("x" == array[i][j] == array[i][j - 1] == array[i][j - 2]):
                answer = True
                
    for i in range (2):
        for j in range (4):
            if ("x" == array[i][j] == array[i + 1][j] == array[i + 2][j]):
                answer = True
                
    for i in range (2, 4):
        for j in range (4):
            if ("x" == array[i][j] == array[i - 1][j] == array[i - 2][j]):
                answer = True
                
    for i in range (2):
        for j in range (2):
            if ("x" == array[i][j] == array[i + 1][j + 1] == array[i + 2][j + 2]):
                answer = True
    
    for i in range (2, 4):
        for j in range (2):
            if ("x" == array[i][j] == array[i - 1][j + 1] == array[i - 2][j + 2]):
                answer = True
                
    for i in range (2):
        for j in range (2, 4):
            if ("x" == array[i][j] == array[i + 1][j - 1] == array[i + 2][j - 2]):
                answer = True
                
    for i in range (2, 4):
        for j in range (2, 4):
            if ("x" == array[i][j] == array[i - 1][j - 1] == array[i - 2][j - 2]):
                answer = True
    return answer
            
array = []
for i in range (4):
    str  = input()
    array.append([])
    for j in range (4):
        array[i].append(str[j])

ans = False
for i in range (4):
    for j in range (4):
        if (array[i][j] == "."):
            array[i][j] = "x"
            ans = proof(array)
            array[i][j] = '.'
        if (ans):
            break
    if (ans):
        break
if (ans):
    print("YES")
else:
    print("NO")