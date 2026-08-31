n=int(input())
s=[[0,0]]*n
for i in range(n):
    s[i]=list(map(int,input().split()))
if(n>1):
    a=2
else:
    a=1
i=1
while(i<=n-2):
    if(s[i][0]-s[i-1][0]>s[i][1]):
        a+=1       
    elif(s[i+1][0]-s[i][0]>s[i][1]):
        a+=1
        s[i][0]=s[i][0]+s[i][1]
    i=i+1
print(a)    
        