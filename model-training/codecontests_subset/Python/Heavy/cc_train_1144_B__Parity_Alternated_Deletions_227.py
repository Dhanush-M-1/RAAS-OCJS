n=int(input())
h=input()
ch=0
nch=0
nch1=0
k=0
s=0
mas=(list(map(int,(h.split(' ')))))
for i in range(n):
    if mas[i]%2==0:
        ch=ch+1
    else:
        nch=nch+1
if abs(nch-ch)<=1:
    print(0)
else:
    k=nch-ch
    if k>0:
        nch1=1
    else:
        nch1=0
    mas.sort()
    i=0
    k=abs(k)-1
    while k!=0:
        if nch1==1:
            if mas[i]%2!=0:
                s=s+mas[i]
                k=k-1
        else:
            if mas[i]%2==0:
                s=s+mas[i]
                k=k-1
        i=i+1
    print(s)