k=int(input())
c=[]
sum=0
for i in range(k):
       b=[int(b) for b in input().split()]
       c.append(b)
for x in range(k):
       for y in range(2):
              if x<k-1 and y<1:
                     for m in range(1,k-x):
                            if c[x][y]==c[x+m][y+1]:
                                   sum=sum+1
              if x<k-1 and y==1:
                     for m in range(1,k-x):
                            if c[x][y]==c[x+m][0]:
                                   sum=sum+1
              
print(sum)
              
                                                            