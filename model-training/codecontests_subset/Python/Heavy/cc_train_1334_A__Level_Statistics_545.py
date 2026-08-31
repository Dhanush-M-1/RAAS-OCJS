t=int(input())
while t>0:
    t-=1
    n=int(input())
    play=[]
    clear=[]
    z=n
    while z>0:
        p,c=map(int,input().split())
        play.append(p)
        clear.append(c)
        z-=1
    a=1
    b=1
    c=1
    d=1

    for i in range(n):
        if clear[i]>play[i]:
            a=0
            break

    for i in range(n-1):
        if (clear[i+1]<clear[i]) or (play[i+1]<play[i]):
            b=0
            break

    for i in range(n-1):
        if (clear[i+1]>clear[i]) and play[i+1]<=play[i]:
            c=0
            break


    for i in range(n-1):
        if clear[i+1]-clear[i]>play[i+1]-play[i]:
            d=0
            break


    if a==1 and b==1 and c==1 and d==1:
        print('YES')
    else:
        print('NO')



