for _ in range(int(input())):
    n=int(input())
    a,b=map(int,input().split())
    f=0
    if(a<b):
        f=1
    for i in range(n-1):
        p,c=map(int,input().split())
        if(f==0):
            if(p<a or c<b):
                f=1
                #break
            elif(p-a<c-b):
                f=1
                #break
            elif(p<c):
                f=1
            else:
                a=p
                b=c
    if(f==1):
        print("NO")
    else:
        print("YES")