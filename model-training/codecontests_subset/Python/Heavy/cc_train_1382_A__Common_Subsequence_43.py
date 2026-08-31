t=int(input(''))
for l in range(t):
    s=input('')
    st=s.split(' ')
    n=int(st[0])
    m=int(st[1])
    li1=list(map(int,input().split()))[:n]
    li2=list(map(int,input().split()))[:m]
    dic1=dict();
    dic2=dict();
    flag=True;
    for i in li1:
        if i in dic1:
            dic1[i]+=1;
        else:
            dic1[i]=1;
    for i in li2:
        if i in dic2:
            dic2[i]+=1;
        else:
            dic2[i]=1;
    for i in dic1:
        if(i in dic2):
            print('YES')
            print(1,i)
            flag=False;
            break
    if(flag):
        print('NO')

