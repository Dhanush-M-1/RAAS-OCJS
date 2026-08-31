def tri():
    n=int(input())
    for i in range(n):
        a=int(input())
        b=input().strip().split()
        if int(b[0])+int(b[1])<=int(b[len(b)-1]):
            print(1,2,len(b))
        else:
            print(-1)

tri()