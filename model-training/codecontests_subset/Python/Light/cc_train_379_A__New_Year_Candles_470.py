
s=input().split()
n=int(s[0])
x=int(s[1])
t=0
result=0
while n>0:
    n-=1
    result+=1
    t+=1
    if t==x:
        n+=1
        t-=x
print(result)    
