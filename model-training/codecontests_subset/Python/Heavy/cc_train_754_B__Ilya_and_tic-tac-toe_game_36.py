a=input()
b=input()
c=input()
d=input()
flag=0

for x in range(0,2):
    if((a[x]=="x" and a[x+1]=="x" and a[x+2]==".") or (a[x]=="." and a[x+1]=="x" and a[x+2]=="x") or (a[x]=="x" and a[x+1]=="." and a[x+2]=="x")):
       
        flag=1
    elif((b[x]=="x" and b[x+1]=="x" and b[x+2]==".") or (b[x]=="." and b[x+1]=="x" and b[x+2]=="x") or (b[x]=="x" and b[x+1]=="." and b[x+2]=="x")):
        
        flag=1
    elif((c[x]=="x" and c[x+1]=="x" and c[x+2]==".") or (c[x]=="." and c[x+1]=="x" and c[x+2]=="x") or (c[x]=="x" and c[x+1]=="." and c[x+2]=="x")):
       
        flag=1
    elif((d[x]=="x" and d[x+1]=="x" and d[x+2]==".") or (d[x]=="x" and d[x+1]=="." and d[x+2]=="x") or (d[x]=="x" and d[x+1]=="." and d[x+2]=="x")):
       
        flag=1
        
for x in range(0,2):
    if((a[x]=="x" and b[x+1]=="x" and c[x+2]==".") or (a[x]=="x" and b[x+1]=="." and c[x+2]=="x") or (a[x]=="." and b[x+1]=="x" and c[x+2]=="x")):
        
        flag=1
    if((a[x+2]=="x" and b[x+1]=="x" and c[x]==".") or (a[x+2]=="x" and b[x+1]=="." and c[x]=="x") or (a[x+2]=="." and b[x+1]=="x" and c[x]=="x")):
        
        flag=1
    if((b[x]=="x" and c[x+1]=="x" and d[x+2]==".")or(b[x]=="x" and c[x+1]=="." and d[x+2]=="x") or (b[x]=="." and c[x+1]=="x" and d[x+2]=="x")):
        
        flag=1
    if((b[x+2]=="x" and c[x+1]=="x" and d[x]==".") or (b[x+2]=="x" and c[x+1]=="." and d[x]=="x") or (b[x+2]=="." and c[x+1]=="x" and d[x]=="x")):
       
        flag=1
     
for x in range(0,4):
    if(a[x]=="x" and b[x]=="x" and c[x]==".")or (a[x]=="x" and b[x]=="." and c[x]=="x") or (a[x]=="." and b[x]=="x" and c[x]=="x"):
       
        flag=1
    if(d[x]=="x" and b[x]=="x" and c[x]==".")or (d[x]=="x" and b[x]=="." and c[x]=="x") or (d[x]=="." and b[x]=="x" and c[x]=="x"):
        
        flag=1
        
    
if(flag==1):
    print("YES")
   
else:
    print("NO")
        
        
