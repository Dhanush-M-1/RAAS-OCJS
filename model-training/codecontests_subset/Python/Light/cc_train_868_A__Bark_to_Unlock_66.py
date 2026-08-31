pas = list(input())
n = int(input())
act=[]
for i in range(n):
    mat = list(input())
    act.append(mat)
flag =0 
for i in range(n):
    if pas[0]==act[i][1]:
        for j in range(n):
            if pas[1]==act[j][0]:
                flag=1
                break
for i in range(n):
    if pas == act[i]:
        flag=1
        break
if flag==0:
    print('NO')
elif flag==1:
    print('YES')