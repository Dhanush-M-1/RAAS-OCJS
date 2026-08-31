s=input()
n=int(input())
a=[]
for i in range(n):
    a.append(input())
    if a[i]==s:
        print('YES')
        exit()
for i in a:
    for j in a:
        if (i[1]+j[0])==s:
            print('YES')
            exit()
print('NO')
