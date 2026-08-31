t=int(input())
while t:
    n=int(input())
    maze=[[0]*n]*n
    for i in range(n):
        s=input()
        row=[i for i in s]
        maze[i]=row
    s_right=maze[0][1]
    s_down=maze[1][0]
    f_up=maze[n-2][n-1]
    f_left=maze[n-1][n-2]
    f=[f_up,f_left]
    if s_right not in f and s_down not in f:
        print(0)
        t-=1
        continue
    if s_right!=s_down and f_left!=f_up:
        if s_right==f_up and s_down==f_left:
            print(2)
            print(1,2)
            print(n,n-1)
            t-=1
            continue
        else:
            print(2)
            print(1,2)
            print(n-1,n)
            t-=1
            continue
        

    if f_up==f_left:
        num=f_up
        if s_right!=s_down:
            if s_right==num:
                print(1)
                print(1,2)
                t-=1
                continue
            if s_down==num:
                print(1)
                print(2,1)
                t-=1
                continue
    if s_right==s_down:
        num1=s_right
        if f_up!=f_left:
            if f_up==num1:
                print(1)
                print(n-1,n)
                t-=1
                continue
            if f_left==num1:
                print(1)
                print(n,n-1)
                t-=1
                continue
    if num==num1:
        print(2)
        print(1,2)
        print(2,1)
        t-=1
        continue
    
    
    t-=1