a=list(list(input()) for i in range(4))
t=0
q=2
w=1
#по гориз
for i in range(2):
    for j in range(4):
        q=2
        w=1
        for k in range(3):
            if a[j][i+k]=='x':
                q-=1
            elif a[j][i+k]=='.':
                w-=1
            else:
                q=2
                w=1
                break
        if q==0 and w==0:
            print("YES")
            exit()
        q=2
        w=1
# по вертик
for i in range(2):
    for j in range(4):
        q=2
        w=1
        for k in range(3):
            if a[i+k][j]=='x':
                q-=1
            elif a[i+k][j]=='.':
                w-=1
            else:
                q=2
                w=1
                break
        if q==0 and w==0:
            print("YES")
            exit()
        q=2
        w=1
# по глав диаг
for i in range(2):
    for j in range(2):
        q=2
        w=1
        for k in range(3):
            if a[2-k+j][k+i]=='x':
                q-=1
            elif a[2-k+j][k+i]=='.':
                w-=1
            else:
                q=2
                w=1
                break
        if q==0 and w==0:
            print("YES")
            exit()
        q=2
        w=1
# по побоч диаг
for i in range(2):
    for j in range(2):
        q=2
        w=1
        for k in range(3):
            if a[k+j][k+i]=='x':
                q-=1
            elif a[k+j][k+i]=='.':
                w-=1
            else:
                q=2
                w=1
                break
        if q==0 and w==0:
            print("YES")
            exit()
        q=2
        w=1
print("NO")
