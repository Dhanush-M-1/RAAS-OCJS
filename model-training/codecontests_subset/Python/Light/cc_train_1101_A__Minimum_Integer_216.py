for i in range (int(input())):
    l,r,d=map(int,input().split())
    if(d<l):
        print(d)
    elif(d>r):
        print(d)
    else:
        print(((r//d)+1)*d)
