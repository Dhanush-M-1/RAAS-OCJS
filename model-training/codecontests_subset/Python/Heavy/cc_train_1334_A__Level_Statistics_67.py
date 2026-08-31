t = int(input())
for _ in range(t):
    n = int(input())
    pp=-1
    pc=-1
    f=1
    for k in range(n):
        a,b = map(int,input().split())
        if(f==1 and pp==-1 and pc==-1):
            if(a<b):
                print("NO")
                f=0
            pp=a
            pc=b
        else:
            if(f==1 and (a<pp or b<pc)):
                print("NO")
                f=0
            if(f==1 and a==pp and (pc-b)!=0):
                print("NO")
                f=0
            if(f==1 and (a-pp < b-pc)):
                print("NO")
                f=0
        pp = a
        pc = b
    if(f==1):   
        print("YES")
            
                
