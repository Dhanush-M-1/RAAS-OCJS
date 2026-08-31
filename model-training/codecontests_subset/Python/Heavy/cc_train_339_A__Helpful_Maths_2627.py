c=[]
m=[]
a=[]
u=0
x=input()
if len(x)<=100:
    for n in x:
       m.append(n)
   # print('m=',m)   
    
    for z in range(len(m)):
       c.append(max(m))
      # print('c=',c)
       b=max(m)
       
       
       m.remove(b)
    
    d=len(c)//2   
    for s in range(len(c)-d):
        a.append(c[s])
        a.sort()
    #print('a=',a)    
    for f in a:
       # print('len(a)=',len(a))
        u=u+1

        if u==len(a):
            print(f)
            break
        print(f,end='+')
        
