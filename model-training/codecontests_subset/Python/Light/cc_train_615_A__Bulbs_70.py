n,m=map(int,input().split())
l=[]
res=""
for x in range(n):
    no_of_bulb,*bno=map(int,input().split())
    l.extend(bno)
for i in range(1,m+1):
    if l.count(i)>0:
        res="YES"
    else:
        res="NO"
        break
print(res)