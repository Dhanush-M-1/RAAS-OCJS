for x in range(int(input())):
    n = int(input())
    l=[]
    for i in range(n):
        s=input()
        l.append(s)
    if l[n-1][n-2]!=l[n-2][n-1]:
        if l[1][0]==l[0][1]:
            print(1)
            if l[n-1][n-2]==l[1][0]:
                print(n,n-1) 
            else:
                print(n-1,n)
        else:
            print(2)
            if l[n-1][n-2]!=l[1][0]:
                print(n,n-1)
                print(2,1)
            else:
                print(n,n-1)
                print(1,2)
    else:
        if l[1][0]==l[0][1]:
            if l[n-1][n-2]!=l[1][0]:
                print(0)
            else:
                print(2)
                print(2,1)
                print(1,2)
        else:
            if l[n-1][n-2]!=l[1][0]:
                print(1)
                print(1,2)
            else:
                print(1)
                print(2,1)
            
        
                
        