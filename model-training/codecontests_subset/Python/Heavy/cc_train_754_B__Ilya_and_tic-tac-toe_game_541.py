
# coding: utf-8

# In[3]:

def p_po_vertik(mas,y,x):
    if mas[y+1][x] == '.' and mas[y+2][x] =='x':
        return 1
    if mas[y-1][x] == '.' and mas[y-2][x] =='x':
        return 1
    if mas[y][x+1] == '.' and mas[y][x+2] =='x':
        return 1
    if mas[y][x-1] == '.' and mas[y][x-2] =='x':
        return 1
    if mas[y+1][x+1] == '.' and mas[y+2][x+2] =='x':
        return 1
    if mas[y-1][x-1] == '.' and mas[y-2][x-2] =='x':
        return 1
    if mas[y-1][x+1] == '.' and mas[y-2][x+2] =='x':
        return 1
    if mas[y+1][x-1] == '.' and mas[y+2][x-2] =='x':
        return 1
    if mas[y+1][x] == 'x' and mas[y+2][x] =='.':
        return 1
    if mas[y-1][x] == 'x' and mas[y-2][x] =='.':
        return 1
    if mas[y][x+1] == 'x' and mas[y][x+2] =='.':
        return 1
    if mas[y][x-1] == 'x' and mas[y][x-2] =='.':
        return 1
    if mas[y+1][x+1] == 'x' and mas[y+2][x+2] =='.':
        return 1
    if mas[y-1][x-1] == 'x' and mas[y-2][x-2] =='.':
        return 1
    if mas[y-1][x+1] == 'x' and mas[y-2][x+2] =='.':
        return 1
    if mas[y+1][x-1] == 'x' and mas[y+2][x-2] =='.':
        return 1

flag = 0    
a = [[0 for j in range(8)] for i in range(8)]
for i in range(4):
    stroka = input()
    for j in range(4):
        
        a[i+2][j+2] = stroka[j]

for i in range(8):
    if flag == 1:
        break
    for j in range(8):
        if a[i][j] == 'x':
            if p_po_vertik(a,i,j) == 1:
                print('YES')
               
                flag = 1
                break
if flag == 0:
    print("NO")
            

            
            



