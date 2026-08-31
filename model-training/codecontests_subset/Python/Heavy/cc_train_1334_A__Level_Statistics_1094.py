for _ in range(int(input())):
    te=[]
    n=int(input())
    x=0
    d={}
    plays=0
    clear=0
    for i in range(n):
        a,b=list(map(int,input().split()))
        if(clear>b or plays>a or b>a or (a-plays)<(b-clear)):
            x=1
        else:
            clear=b
            plays=a
            if(a in d.keys()):
                if(b in d[a]):
                    d[a].append(b)
                elif(b not in d[a]):
                      x=1
            else:
                d[a]=[b]
            
       
    if(x==1):
        print('NO')
    
    if(x==0):
        print('YES')

            