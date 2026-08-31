n=int(input())
a=[int(x) for x in input().split()]
z=a[:]
z.sort(reverse=True)

an=[[] for i in range(n+1)]
an[0]=a[:]
for i in range(n):
    
    for j in range(len(a)-1,-1,-1) :
      #  print(j,z)
        if a[j]==z[-1]:
            del a[j]
            z.pop()
            break
    an[i+1]=a[:]
    
an=an[::-1]
for j in range(int(input())):
    x,y=map(int,input().split())
    print(an[x][y-1])
