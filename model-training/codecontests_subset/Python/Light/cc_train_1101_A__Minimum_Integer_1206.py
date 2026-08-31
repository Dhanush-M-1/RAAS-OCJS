
for i in range(int(input())):
    l,r,d=map(int,input().split())
   

    if d<l:
        print(d)

    else:
        c=r//d
        print(int(d*(c+1)))