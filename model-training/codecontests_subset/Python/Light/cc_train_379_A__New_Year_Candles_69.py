inp = list(map(int,input().split()))
a=inp[0]
b=inp[1]
sumi=a
while(a>0):
    sumi=sumi+(a//b)
    if(a//b!=0):
        a=a//b+(a-(a//b)*b)
    else:
        a=a//b
print (sumi)