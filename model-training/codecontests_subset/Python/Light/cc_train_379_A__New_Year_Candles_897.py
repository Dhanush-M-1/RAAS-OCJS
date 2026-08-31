a,b=[int(i) for i in input().split()]
t=0
new=a
left=0
burned=0
while True:
    if new!=0:
        t+=new
        burned=new+left
        new=int(burned/b)
        left=burned%b
        continue
    else:
        break

print(t)
