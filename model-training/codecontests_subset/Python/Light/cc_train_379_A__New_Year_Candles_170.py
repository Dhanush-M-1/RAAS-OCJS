ab=input().split()
a=int(ab[0])
b=int(ab[1])
i=a
r=0
count=0
while(i>0):
    count+=i
    q=i//b
    r+=i%b
    if(r//b>0):
        q+=r//b
        r%=b
    i=q
print(count)
    