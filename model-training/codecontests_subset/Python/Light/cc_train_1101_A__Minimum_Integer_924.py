for _ in range(int(input())):
        l,r,d=map(int,input().split())
        if(d<l):
                print(d)
        elif(d<=r):
                print(r+d-(r%d))
        elif(d>r):
                print(d)
