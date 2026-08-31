q=input()
n,k=q.split()

a=input()
a=a.split()
list=[]
for b in a:
    b=int(b)
    list.append(b)
    
k=int(k)    
res=10000000
for a in list:
    if k%a==0 and (k/a)<res:
        res=(k/a)
        
print(int(res))        
    

