t=int(input())
for i in  range(t):
    n=int(input())
    a=[int(i) for i in input().split()]
    v=a[0]+a[1]
    a=a[2:]
    f=0
    for i in range(len(a)):
        if(v<=a[i]):
           print("1 2",i+3,end='\n')
           f=1
           break
       
    if(not f):
        print("-1",end='\n')