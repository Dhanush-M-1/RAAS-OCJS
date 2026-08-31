for i in range(int(input())):
    x,y,z=map(int,input().split())
    if(x>z):
        print(z)
    else:
        a=y//z
        print(z*(a+1))
