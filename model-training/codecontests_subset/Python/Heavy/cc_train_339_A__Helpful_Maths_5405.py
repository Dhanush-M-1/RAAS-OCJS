s = input()
a=0
b=0
c=0

for i in range (0, len(s)):
    if(s[i]=='1'):
        a=a+1
    if(s[i]=='2'):
        b = b+1
    if(s[i]=='3'):
        c=c+1


s1=''
n=0
while(a>0):
    if(n%2==0):
        s1=s1+'1'
        n=n+1
        a=a-1
    if(n%2==1):
        s1=s1+'+'
        n=n+1
    

while(b>0):
    if(n%2==0):
        s1=s1+'2'
        n=n+1
        b=b-1
    if(n%2==1):
        s1=s1+'+'
        n=n+1

while(c>0):
    if(n%2==0):
        s1=s1+'3'
        n=n+1
        c=c-1
    if(n%2==1):
        s1=s1+'+'
        n=n+1

if(s1[len(s1)-1]=='+'):
    s1=s1[0:len(s1)-1]
print(s1)


   
