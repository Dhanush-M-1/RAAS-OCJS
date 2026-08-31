s=input().split()
print(s[0],s[1])
t=int(input())
while t>0:
    t-=1
    s1=input().split()
    if(s[0]==s1[0]):
        s[0]=s1[1]
    else:
        s[1]=s1[1]
    print(s[0],s[1])