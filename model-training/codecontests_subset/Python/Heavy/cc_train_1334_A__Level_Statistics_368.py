for test in range(int(input())):
    n = int(input())
    l1=[]
    l2=[]
    pl1=0
    pl2=0
    c1=c2=0
    for i in range(n):
        a,b = map(int,input().split())
        l1.append(a)
        l2.append(b)
    for j in range(n):
        if j<1:
            if l1[0] < l2[0]:
                print('NO')
                break
            else:
                c1=c1+1
        else:
            d1=l1[j]-l1[j-1]
            d2=l2[j]-l2[j-1]
            if d1 >= 0 and d2 >= 0 and d1 >= d2 and l1[j]>=l2[j]:
                c1=c1+1
            else:
                print('NO')
                break
    if c1>=n:
        print('YES')


