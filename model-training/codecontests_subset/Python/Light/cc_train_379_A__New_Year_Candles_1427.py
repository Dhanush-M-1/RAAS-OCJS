x,y=map(int,input().split(" "))
u=(x/y)+(x%y)
j=0
while(u>=y):
    p=int(u/y)
    u=p+(u%y)
    j=j+p
    #print(j)
w=int(x+(x/y)+j)
print(w)
