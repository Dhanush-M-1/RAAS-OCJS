n=int(input())
s=input()
a=0
b=0
for i in range(n):
    if (s[i]=="1"):
        a+=1
    elif (s[i]=="0"):
        b+=1
if (a!=b):
    print(1)
    print(s)
else:
    if (n==2):
        print(2)
        print(s[0],s[1])
    else:
        c=[]
        d=[]
        for j in range(1,n):
            c=s[:j]
            d=s[j:]
            g=0
            h=0
            l=0
            m=0
            for k in range(j):
                if(c[k]=="1"):
                    g+=1
                else:
                    h+=1
            for k in range(n-j):
                if(d[k]=="1"):
                    l+=1
                else:
                    m+=1
            if ((g!=h) and (l!=h)):
                print(2)
                print(c,d)
                break
        

        
    
