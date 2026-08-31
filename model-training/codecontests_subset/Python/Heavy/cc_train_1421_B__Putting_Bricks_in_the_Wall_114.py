t=int(input())
for i in range(t):
    n=int(input())
    m=[[i for i in input()] for i in range(n)]
    #print(m)
    q=int(m[1][0])
    w=int(m[0][1])
    a=int(m[-1][-2])
    s=int(m[-2][-1])
    e=n-1
    if q == w:
        if a == s:
            if q == a:
                print('2','\n','1 2','\n','2 1',sep='')
            else:
                print('0')
        else:
            if q == a:
                print('1','\n',n,' ',e,sep='')
            else:
                print('1','\n',e,' ',n,sep='')
    else:
        if a == s:
            if q == a:
                print('1','\n','2 1',sep='')
            else:
                print('1','\n','1 2',sep='')
        else:
            if q == a:
                print('2','\n','1 2','\n',n,' ',e,sep='')
            else:
                print('2','\n','1 2','\n',e,' ',n,sep='')