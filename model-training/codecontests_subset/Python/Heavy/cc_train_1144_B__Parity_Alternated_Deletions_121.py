n=int(input())
a=[int(x) for x in input().split()]
ch=ne=0
ch1=[]
ne1=[]
summa=0
for item in a:
    if item%2==0:
        ch+=1
        ch1.append(item)
    else:
        ne+=1
        ne1.append(item)
ch1.sort(reverse=True)
ne1.sort(reverse=True)
if ch>ne:
    for i in range(ne):
        summa+=ne1[i]
    for i in range(ne+1):
        summa+=ch1[i]
elif ch<ne:
    for i in range(ch):
        summa+=ch1[i]
    for i in range(ch+1):
        summa+=ne1[i]
else:
    summa=sum(a)
print(sum(a)-summa)
    

