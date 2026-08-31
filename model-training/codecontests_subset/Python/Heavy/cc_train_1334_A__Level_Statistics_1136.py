t=int(input())
while t>0 :
    n=int(input())
    flag=0
    pg,pc=map(int,input().split())
    if pc>pg :
        for i in range(n-1):
            g,c=map(int,input().split())
        print("NO")
    else :
        for i in range(n-1):
            g,c=map(int,input().split())
            if (c>g) or (c-pc>g-pg )or (pg>g) or (pc>c) :
                flag=1
            else :
                pg=g 
                pc=c 
        if flag==0 :
            print("YES")
        else :
            print("NO")
    t-=1