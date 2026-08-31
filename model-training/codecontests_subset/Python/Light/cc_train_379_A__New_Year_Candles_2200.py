n,m=[int(x) for x in input().split()]
re=n
c=0
rem=0
while(re):
    re-=1
    rem+=1
    if(rem==m):
        re+=1
        rem=0
    c+=1
print(c)    
