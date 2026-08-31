for i in range(int(input())):
    l,r,d=map(int,input().split())
    print(d if(d<l or d>r) else d*((r//d)+1))