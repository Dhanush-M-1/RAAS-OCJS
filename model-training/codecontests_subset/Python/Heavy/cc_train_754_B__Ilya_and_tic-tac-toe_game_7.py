def fct(l):
    for j in range(8):
        for p in range(8):
            if l[j][p]=='.':
                if check(j,p):
                    return True
    return False
                
def check(j,p):
    a=0
    b=0
    c=0
    d=0
    if l[j+1][p]=='x':
        a+=1
        if l[j+2][p]=='x':
            a+=1
    if l[j-1][p]=='x':
        a+=1
        if l[j-2][p]=='x':
            a+=1 
            
    if l[j-1][p+1]=='x':
        b+=1
        if l[j-2][p+2]=='x':
            b+=1
    if l[j+1][p-1]=='x':
        b+=1
        if l[j+2][p-2]=='x':
            b+=1 
            
    if l[j][p+1]=='x':
        c+=1
        if l[j][p+2]=='x':
            c+=1
    if l[j][p-1]=='x':
        c+=1
        if l[j][p-2]=='x':
            c+=1 
            
    if l[j+1][p+1]=='x':
        d+=1
        if l[j+2][p+2]=='x':
            d+=1
    if l[j-1][p-1]=='x':
        d+=1
        if l[j-2][p-2]=='x':
            d+=1 
            
            
    if b>1 or a>1 or c>1 or d>1:
        return True
    else:
        return False
            
            
        
        
l=[]
l.append("########")
l.append("########")
for i in range(4):
    l.append("##"+input()+"##")
l.append("########")
l.append("########")
if fct(l):
    print("YES")
else:
    print("NO")