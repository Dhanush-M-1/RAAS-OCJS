n,m=map(int,input().split())
a=[int(o) for o in input().split()]
b1=[int(o) for o in input().split()]
a=sorted(a)
b1=sorted(b1)
c=b1[-1]
jhand=[]
for i in range(n):
    if c>=a[i]:
        b=c-a[i]
        lol=[0]*n
        for i in range(n):
            lol[i]=(a[i]+b)%m
        lol.sort()
      #  print(lol,b)
        if lol==b1:
            jhand.append(b)
    else:
        b=c+m-a[i]
        lol=[0]*n
        for i in range(n):
            lol[i]=(a[i]+b)%m
        lol.sort()
      #  print(lol,b)
        if lol==b1:
            jhand.append(b)
print(min(jhand))
        


