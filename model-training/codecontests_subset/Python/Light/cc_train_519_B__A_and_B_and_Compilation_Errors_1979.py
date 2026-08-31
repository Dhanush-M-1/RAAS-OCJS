n=int(input())
a=[int(i) for i in input().split()]
b=[int(i) for i in input().split()]
c=[int(i) for i in input().split()]
a.sort()
b.sort()
c.sort()
cou=0
for i in range(len(b)):
    if a[i]!=b[i]:
        print(a[i])
        cou+=1
        break
if(cou==0):
    print(a[n-1])
cou=0
for i in range(len(c)):
    if b[i]!=c[i]:
        print(b[i])
        cou+=1
        break
if(cou==0):
    print(b[n-2])







    


        

