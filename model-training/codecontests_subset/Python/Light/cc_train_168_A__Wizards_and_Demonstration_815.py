
n,x,y=map(int,input().split())
c=0
while True:
    p=(x*100)/n
    if p>=y:
        print(c);break
    x+=1;c+=1
