s1,s2=input().split()
n=int(input())
print(s1,s2)
while n>0:
    n-=1
    a,b=input().split()
    if a==s1:
        s1=b
    else :
        s2=b
    print(s1,s2)