T = int(input())
for t in range(T):
    n = int(input())
    g = [input() for i in range(n)]
    a,b,c,d=g[0][1],g[1][0],g[-1][-2],g[-2][-1]
    #a,b,c,d=0,0,1,1
    #print(a,b,c,d)
    ans = 0
    if (a==b=='0' and c==d=='1') :
        ans = 0
        print(0)
    elif  (a==b=='1' and c==d=='0'):  
        ans = 0
        print(ans)
    elif a==b==c==d:
        ans =2
        print(ans)
        print(1,2)
        print(2,1)
    elif(a!=b and c!=d):  
        if a==c:
            print(2)
            print(2,1)
            print(n,n-1)
        elif a==d:
            print(2)
            print(2,1)
            print(n-1,n)
    elif (a!=b and c==d):
        ans = 1
        print(ans)
        if a==c:
            print(1,2)
        else:
            print(2,1)
    elif(a==b and c!=d) :   
        ans = 1
        print(ans)
        if a==c:
            print(n,n-1)
        else:
            print(n-1,n) 
        
        