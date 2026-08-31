h = input()
h = list(h)
a=0
b=0
c=0
ans=''
for i in range(len(h)):
    if(h[i]=='1'):
        a=a+1
    if(h[i]=='2'):
        b=b+1    
    if(h[i]=='3'):
        c=c+1
for i in range(a):
    if(i==a-1):
        if(b==0 and c==0):
            ans=ans+'1'
        else:
            ans=ans+'1'+'+'            
    else:    
        ans=ans+'1'+'+'
for i in range(b):
    if(i==b-1):
        if(c==0):
            ans=ans+'2'
        else:
            ans=ans+'2'+'+'
    else:    
        ans=ans+'2'+'+'
for i in range(c):
    if(i==c-1):
        ans=ans+'3'
    else:    
        ans=ans+'3'+'+'        
print(ans)        