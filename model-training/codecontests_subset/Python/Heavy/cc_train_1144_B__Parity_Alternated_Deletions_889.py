n=int(input())
eve=[]
odd=[]
ev=0
od=0
s=[]
sum1=0
d=[]
x=list(map(int,input().split()))
for r in x:
    if r%2==0:
        ev=ev+1
        eve.append(r)
    else:
        od=od+1
        odd.append(r)
t=ev-od
f=abs(t)
eve.sort()
odd.sort()
if ev==od or abs(ev-od)==1:
    print("0")
else:
    if t>0:
        for i in range(f-1):
            sum1=0
            s.append(eve[i])
            #print(s)
            for i in range(len(s)):
                sum1=sum1+s[i]
    else:
        for i in range(f-1):
            sum1=0
            d.append(odd[i])
            for i in range(len(d)):
                sum1=sum1+d[i]
            #print(d)
    print(sum1)
