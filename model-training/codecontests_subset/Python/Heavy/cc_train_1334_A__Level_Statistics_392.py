x=int(input())
l=[]
for z in range(x):
    n=int(input())
    l.clear()
    for i in range(n):
        c=list(map(int,input().split()))
        l.append(c)
    #print(l)
    f=0
    if l[0][1]>l[0][0]:
            print('NO')
            f=2
    elif n==1:
            print('YES')
            f=2
    else:
        for i in range(n-1):
                if l[i+1][0]<l[i][0] or l[i+1][1]<l[i][1]:
                    print('NO')
                    f=1
                    break
                elif (l[i+1][0]-l[i][0])<(l[i+1][1]-l[i][1]):
                    print('NO')
                    f=1
                    break
        if f==0:
                print('YES')