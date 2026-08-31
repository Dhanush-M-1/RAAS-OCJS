z=int(input())
for i in range(z):
    x=int(input())
    s=str(input())
    a=s.count('>')
    b=s.count('<')
    if(a==0 or b==0):
        print(0)
    else:
        m=[]
        if(s[0]=='<'):
            for j in range(0,len(s)):
                if(s[j]=='<'):
                    m.append(j)
                else:
                    break
           
        n=[]
        if(s[len(s)-1]=='>'):
            s=s[::-1]
            for j in range(0,len(s)):
                if(s[j]=='>'):
                    n.append(j)
                else:
                    break
        g=min(len(n),len(m))
        print(g)