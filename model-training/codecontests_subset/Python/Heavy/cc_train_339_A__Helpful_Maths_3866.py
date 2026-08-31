s=input()
c1=0
c2=0
c3=0
for i in range(0,len(s)):
    if(s[i]=='1'):
        c1+=1
    if(s[i]=='2'):
        c2+=1
    if(s[i]=='3'):
        c3+=1
k=c1+c2+c3

for i in range(0,k):
    if(i<c1):
        if(i==k-1):
            print("1",end=""),
        else:
            print("1+",end=""),
    elif(i<c1+c2):
        if(i==k-1):
            print("2",end=""),
        else:
            print("2+",end=""),
    else:
        if(i==k-1):
            print("3",end=""),
        else:
            print("3+",end=""),
        
        

        
    
        
    
        
        
    
