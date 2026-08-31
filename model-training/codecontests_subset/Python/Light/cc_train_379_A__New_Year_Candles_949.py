a=str(input(""))
b=a.split(" ")
c=int(b[0])
d=int(b[1])
x=int(c/d)
rem=c%d
sum1=c

while(x>0):
    sum1=sum1+x
    rem=rem+(x%d)
    x=int(x/d)
    

rem1=rem%d

if(rem>0):
    while(rem>0):
        sum1=sum1+(rem/d)
        rem1=rem1+(rem%d)
        rem=int(rem/d)


print(int(sum1))