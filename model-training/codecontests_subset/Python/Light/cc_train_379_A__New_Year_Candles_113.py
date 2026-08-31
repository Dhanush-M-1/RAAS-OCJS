a,b=map(int,input().split())
c=0
rem=a
while(rem>=b):
    r=rem%b
    rem=rem//b
    c+=rem
    rem=rem+r
print(a+c)
    
    