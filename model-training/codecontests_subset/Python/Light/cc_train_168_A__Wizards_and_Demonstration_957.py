n,x,y=map(int,input().split())
d=0
p=(x*100)/n
while p<y:
    d=d+1
    x=x+1
    p=(x*100)/n
print(d)   
