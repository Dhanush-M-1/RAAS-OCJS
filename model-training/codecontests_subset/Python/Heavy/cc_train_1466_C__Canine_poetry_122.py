for _ in range(int(input())):
    s=str(input())
    a=list(s)
    n=len(s)
    if n==1:
        print(0)
    elif n==2:
        if s[0]==s[1]: print(1)
        else:print(0)
    else:
        l=[[0,0,0] for i in range(n)]
        l[0][0]=s[0]
        if s[0]==s[1]:
            l[1][1]=s[1]
        else: 
            l[1][0]=s[1]
        for i in range(2,n):
            for j in range(3):
                c=0
                for k in range(3):
                    if l[i-k][j]==s[i]:
                        c=1
                if c==0:
                    l[i][j]=s[i]

        #print(l)
        m=n
        for i in range(3):
            z=0
            for j in range(n):
               if l[j][i]==0:
                   z+=1
            m=min(z,m)
        print(m)
        #print(min(z1,z2,z3))
                    
                        
            