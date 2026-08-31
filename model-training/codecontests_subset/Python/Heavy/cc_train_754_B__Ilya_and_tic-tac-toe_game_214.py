a = [[0] * 4 for i in range(4)]
for i in range(4):
    s = input()
    for j in range(4):
        if s[j] == 'x':
            a[i][j] = 1
        elif s[j] == 'o':
            a[i][j] = -1
o = 0
for i in range(4):
    if o == 0:
        for j in range(4):
            if a[i][j] == 1:
                if j < 2:
                    z = 0
                    for k in range(1, 3):
                        if a[i][j + k] == -1:
                            break
                        elif a[i][j + k] == 1:
                            z += 1
                    else:
                        if z == 1:
                            o = 1
                            print('YES')
                            break
                if i < 2:
                    z = 0
                    for k in range(1, 3):
                        if a[i + k][j] == -1:
                            break
                        elif a[i + k][j] == 1:
                            z += 1
                    else:
                        if z == 1:
                            o = 1
                            print('YES')
                            break                    
                if j < 2 and i < 2 :
                    z = 0
                    for k in range(1,3):
                        if a[i + k][j + k] == -1:
                            break
                        elif a[i + k][j + k] == 1:
                            z += 1
                    else:
                        if z == 1:
                            o = 1
                            print('YES')
                            break                    
                if j > 1 and i < 2 :
                    z = 0
                    for k in range(1, 3):
                        if a[i+k][j-k] == -1:
                            break
                        elif a[i+k][j-k] == 1:
                            z += 1
                    else:
                        if z == 1:
                            o = 1
                            print('YES')
                            break   
            elif a[i][j] == 0:
                if j < 2:
                    z = 0
                    for k in range(1, 3):
                        if a[i][j + k] == -1:
                            break
                        elif a[i][j + k] == 1:
                            z += 1
                    else:
                        if z == 2:
                            o = 1
                            print('YES')
                            break
                if i < 2:
                    z = 0
                    for k in range(1, 3):
                        if a[i + k][j] == -1:
                            break
                        elif a[i + k][j] == 1:
                            z += 1
                    else:
                        if z == 2:
                            o = 1
                            print('YES')
                            break                    
                if j < 2 and i < 2 :
                    z = 0
                    for k in range(1,3):
                        if a[i + k][j + k] == -1:
                            break
                        elif a[i + k][j + k] == 1:
                            z += 1
                    else:
                        if z == 2:
                            o = 1
                            print('YES')
                            break                    
                if j > 1 and i < 2 :
                    z = 0
                    for k in range(1, 3):
                        if a[i+k][j-k] == -1:
                            break
                        elif a[i+k][j-k] == 1:
                            z += 1
                    else:
                        if z == 2:
                            o = 1
                            print('YES')
                            break                   
    else:
        break
else:
    if o == 0:
        print('NO')