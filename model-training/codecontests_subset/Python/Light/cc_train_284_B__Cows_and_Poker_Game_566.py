z=int(input());a=i=0
for k in input():
     if k=='A':
        a+=1
     elif k== 'I':
        i+=1
if i>1 or a+i==0:
    print(0)
else:        
     print(['%d'%i,'%d'%a][i==0])                
         