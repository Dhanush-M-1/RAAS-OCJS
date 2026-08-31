s1 = input()
s2 = input()
s3 = input()
s4 = input()
a = [['.' for x in range(4)] for _ in range(4)]
for i in range(4):
    for j in range(4):
        if i == 0:
            a[i][j] = s1[j]
        if i == 1:
            a[i][j] = s2[j]
        if i == 2:
            a[i][j] = s3[j]
        if i == 3:
            a[i][j] = s4[j]
n = 4
for i in range(4):
    for j in range(2):
        if a[i][j] != 'o' and a[i][j+1] != 'o' and a[i][j+2] != 'o':
            temp = []
            temp.append(a[i][j])
            temp.append(a[i][j+1])
            temp.append(a[i][j+2])
            temp = sorted(temp)
            
            if temp[1] != 'x':
                continue
            print("YES")
            exit()
for i in range(2):
    for j in range(4):
        if a[i][j] != 'o' and a[i+1][j] != 'o' and a[i+2][j] != 'o':
            temp = []
            temp.append(a[i][j])
            temp.append(a[i+1][j])
            temp.append(a[i+2][j])
            temp = sorted(temp)
            
            if temp[1] != 'x':
                continue
            print("YES")
            exit()
for i in range(2):
    for j in range(2):
        if a[i][j] != 'o' and a[i+1][j+1] != 'o' and a[i+2][j+2] != 'o':
            temp = []
            temp.append(a[i][j])
            temp.append(a[i+1][j+1])
            temp.append(a[i+2][j+2])
            temp = sorted(temp)
            
            if temp[1] != 'x':
                continue
            print("YES")
            exit()
for i in range(4):
    a[i] = a[i][::-1]
for i in range(4):
    for j in range(2):
        if a[i][j] != 'o' and a[i][j+1] != 'o' and a[i][j+2] != 'o':
            temp = []
            temp.append(a[i][j])
            temp.append(a[i][j+1])
            temp.append(a[i][j+2])
            temp = sorted(temp)
            
            if temp[1] != 'x':
                continue
            print("YES")
            exit()
for i in range(2):
    for j in range(4):
        if a[i][j] != 'o' and a[i+1][j] != 'o' and a[i+2][j] != 'o':
            temp = []
            temp.append(a[i][j])
            temp.append(a[i+1][j])
            temp.append(a[i+2][j])
            temp = sorted(temp)
            
            if temp[1] != 'x':
                continue
            print("YES")
            exit()
for i in range(2):
    for j in range(2):
        if a[i][j] != 'o' and a[i+1][j+1] != 'o' and a[i+2][j+2] != 'o':
            temp = []
            temp.append(a[i][j])
            temp.append(a[i+1][j+1])
            temp.append(a[i+2][j+2])
            temp = sorted(temp)
            
            if temp[1] != 'x':
                continue
            print("YES")
            exit()
print("NO")