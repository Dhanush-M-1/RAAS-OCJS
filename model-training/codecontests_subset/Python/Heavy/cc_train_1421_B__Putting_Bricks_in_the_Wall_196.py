t=int(input())
for i in range(t):
    l=[]
    nl=[]
    c=0
    n=int(input())
    zc=0
    oc=0
    k=0
    a=''
    b=''
    c=''
    d=''
    for i2 in range(n):
        ml=''
        mlt=[]
        ml=input()
        l.append(ml)
    a=l[n-1][n-3]
    b=l[n-2][n-2]
    c=l[n-3][n-1] 
    e=l[n-1][n-2]
    f=l[n-2][n-1]
    while k==0:
        if (a==b)and(a==c):
            if a=='1':
                oc=3
            else:
                zc=3
        elif (a==b)and(a!=c):
            d='c'
            if a=='1':
                oc=2
                zc=1
            else:
                oc=1
                zc=2
        elif (a==c)and(a!=b):
            d='b'
            if a=='1':
                oc=2
                zc=1
                
            else:
                oc=1
                zc=2        
        elif (c==b)and(a!=c):
            d='a'
            if c=='1':
                oc=2
                zc=1
            else:
                oc=1
                zc=2        
        k=1        
                
    #if(l[0][1]=='0')and(l[1][0]=='0'):
     #   if l[n-1][n-2]=='0':
      #      c=c+1
       #     nl.append(n)
        #    nl.append(n-1)
        #if l[n-2][n-1]=='0':
         #   c=c+1
          #  nl.append(n-1)
           # nl.append(n)
   # elif(l[0][1]=='1')and(l[1][0]=='1'):
    #    if l[n-1][n-2]=='1':
     #       c=c+1
      #      nl.append(n)
       #     nl.append(n-1)
        #if l[n-2][n-1]=='1':
         #   c=c+1
          #  nl.append(n-1)
           # nl.append(n)
    if 1>0:
        if (e==f)and(e=='1'):
            if oc==3:
                c=2
                nl=[n,n-1,n-1,n]
            elif oc==0:
                c=0
            #elif zc=3:
            elif oc==2:
                c=2
                if d=='a':
                    nl=[n-1,n-1,n-2,n]
                elif d=='b':
                    nl=[n,n-2,n-2,n] 
                elif d=='c':
                    nl=[n,n-2,n-1,n-1]    
            elif oc==1:
                c=1
                if d=='a':
                    nl=[n,n-2]
                elif d=='b':
                    nl=[n-1,n-1] 
                elif d=='c':
                    nl=[n-2,n] 
                    
        elif (e==f)and(e=='0'):
            if zc==3:
                c=2
                nl=[n,n-1,n-1,n]
            elif zc==0:
                c=0
            #elif zc=3:
            elif zc==2:
                c=2
                if d=='a':
                    nl=[n-1,n-1,n-2,n]
                elif d=='b':
                    nl=[n,n-2,n-2,n] 
                elif d=='c':
                    nl=[n,n-2,n-1,n-1]    
            elif zc==1:
                c=1
                if d=='a':
                    nl=[n,n-2]
                elif d=='b':
                    nl=[n-1,n-1] 
                elif d=='c':
                    nl=[n-2,n]             
                    
        elif (e!=f)and(e=='1'):
            if oc==3:
                c=1
                nl=[n,n-1]
            elif oc==0:
                c=1
                nl=[n-1,n]
            #elif zc=3:
            elif oc==2:
                c=2
                if d=='a':
                    nl=[n,n-1,n,n-2]
                elif d=='b':
                    nl=[n,n-1,n-1,n-1] 
                elif d=='c':
                    nl=[n,n-1,n-2,n]    
            elif oc==1:
                c=2
                if d=='a':
                    nl=[n-1,n,n,n-2]
                elif d=='b':
                    nl=[n-1,n,n-1,n-1] 
                elif d=='c':
                    nl=[n-1,n,n-2,n]             
                    
        elif (e!=f)and(e=='0'):
            if zc==3:
                c=1
                nl=[n,n-1]
            elif zc==0:
                c=1
                nl=[n-1,n]
            #elif zc=3:
            elif zc==2:
                c=2
                if d=='a':
                    nl=[n,n-1,n,n-2]
                elif d=='b':
                    nl=[n,n-1,n-1,n-1] 
                elif d=='c':
                    nl=[n,n-1,n-2,n]    
            elif zc==1:
                c=2
                if d=='a':
                    nl=[n-1,n,n,n-2]
                elif d=='b':
                    nl=[n-1,n,n-1,n-1] 
                elif d=='c':
                    nl=[n-1,n,n-2,n]               
                    
        
        
        
        
        
    print(c)
    if c>0:
        for i4 in range(c):
            print(f'{nl[2*i4]} {nl[2*i4+1]}')

                  