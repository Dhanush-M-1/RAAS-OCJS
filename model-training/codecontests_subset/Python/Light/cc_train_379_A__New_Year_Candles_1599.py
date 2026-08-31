a,b=[int(a) for a in input().split()]
hrs=a
flag=True
rem=0
while flag:
    if a>=b:
        s=a//b
        hrs+=s
        rem=a%b
        a=(s+rem)
    else:
        flag=False
print(hrs)
