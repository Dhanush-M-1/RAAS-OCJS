
bo = []

for i in range(4):
    bo.append(input())

arr = []
for i in range(4):
    a = []
    for j in range(len(bo[i])):
        if bo[i][j] == 'x':
            a.append(1)
        else:
            if bo[i][j] == 'o':
                a.append(2)
            else:
                a.append(0)
    arr.append(a)

st = 0

for i in range(4):
    for j in range(4):
        if j<2:
            a = sorted([arr[i][j],arr[i][j+1],arr[i][j+2]])
            if a==[0,1,1]:
                st = 1
                print("YES")
                break
        if i<2:
            a = sorted([arr[i][j],arr[i+1][j],arr[i+2][j]])
            if a==[0,1,1]:
                st = 1
                print("YES")
                break
        if j<2 and i<2:
            a = sorted([arr[i][j],arr[i+1][j+1],arr[i+2][j+2]])
            if a==[0,1,1]:
                st = 1
                print("YES")
                break
        if j<2 and i>=2:
            a = sorted([arr[i][j],arr[i-1][j+1],arr[i-2][j+2]])
            if a==[0,1,1]:
                st = 1
                print("YES")
                break
    
    if st==1:
        break

if st==0:
    print("NO")
