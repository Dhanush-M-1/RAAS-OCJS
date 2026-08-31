n=int(input())
a=list(map(int,input().split()))
ch=[]
nch=[]
for elem in a:
    if elem%2:
        nch.append(elem)
    else:
        ch.append(elem)
sum1=0
sum2=0
ch.sort()
nch.sort()
z=ch
x=nch
p=1
while p!=0:
    if p%2:
        try:
            ch.pop()
            p+=1
        except:
            break
    else:
        try:
            nch.pop()
            p+=1
        except:
            break
sum1=sum(ch)+sum(nch)
p=1
while p!=0:
    if p%2:
        try:
            x.pop()
            p+=1
        except:
            break
    else:
        try:
            z.pop()
            p+=1
        except:
            break
sum2=sum(x)+sum(z)
print(min(sum1,sum2))

