import math
for _ in range(int(input())):
    n=int(input())
    s=[]
    for i in range(n):
        l=input()
        s.append(l)
    if (s[0][1]=='1' and s[1][0]=='1' and s[n-1][n-2]=='0'  and s[n-2][n-1]=='0' ) or (s[0][1]=='0' and s[1][0]=='0' and s[n-1][n-2]=='1'  and s[n-2][n-1]=='1' ):
        #print(1)
        print(0)
    elif s[0][1]=='1' and s[1][0]=='1':
        #print(2)
        if s[n-1][n-2]=='1' and s[n-2][n-1]=='1':
            print(2)
            print(n,n-1)
            print(n-1,n)
        elif s[n-1][n-2]=='1' and s[n-2][n-1]=='0':
            print(1)
            print(n,n-1)
        elif s[n-1][n-2]=='0' and s[n-2][n-1]=='1':
            print(1)
            print(n-1,n)
        else:
            print(0)
    elif s[0][1]=='0' and s[1][0]=='0':
        #print(3)
        if s[n-1][n-2]=='0' and s[n-2][n-1]=='0':
            print(2)
            print(n,n-1)
            print(n-1,n)
        elif s[n-1][n-2]=='0' and s[n-2][n-1]=='1':
            print(1)
            print(n,n-1)
        elif s[n-1][n-2]=='1' and s[n-2][n-1]=='0':
            print(1)
            print(n-1,n)
        else:
            print(0)
    else:
        #print(4)
        if (s[0][1]=='1' and s[1][0]=='0' and s[n-1][n-2]=='1' and s[n-2][n-1]=='0') or (s[0][1]=='0' and s[1][0]=='1' and s[n-1][n-2]=='0' and s[n-2][n-1]=='1'):
            print(2)
            print(2,1)
            print(n,n-1)
        elif (s[0][1]=='1' and s[1][0]=='0' and s[n-1][n-2]=='0' and s[n-2][n-1]=='1') or (s[0][1]=='0' and s[1][0]=='1' and s[n-1][n-2]=='1' and s[n-2][n-1]=='0'):
            print(2)
            print(1,2)
            print(n,n-1)
        elif (s[0][1]=='1' and s[1][0]=='0' and s[n-1][n-2]=='0' and s[n-2][n-1]=='0') or  (s[0][1]=='0' and s[1][0]=='1' and s[n-1][n-2]=='1' and s[n-2][n-1]=='1'):
            print(1)
            print(2,1)
        elif (s[0][1]=='1' and s[1][0]=='0' and s[n-1][n-2]=='1' and s[n-2][n-1]=='1') or (s[0][1]=='0' and s[1][0]=='1' and s[n-1][n-2]=='0' and s[n-2][n-1]=='0') :
            print(1)
            print(1,2)
        
        
            
    
            
        
    
    
