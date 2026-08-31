for _ in range(int(input())):
    g=int(input())
    game=[]
    for i in range(g):
        a,b=map(int,input().split())
        game.append(a)
        game.append(b)
    play=game[::2]
    clear=game[1::2]
    flag=0
    for i in range(1,g):
        if play[i]<play[i-1] or clear[i]<clear[i-1]:
            flag=1
        if clear[i]-clear[i-1]>play[i]-play[i-1]:
            flag=1
        if play[i]<clear[i]:
            flag=1
    if play[0]<clear[0]:
        flag=1
    if flag==0:
        print('YES')
    elif flag==1:
        print('NO')
    
