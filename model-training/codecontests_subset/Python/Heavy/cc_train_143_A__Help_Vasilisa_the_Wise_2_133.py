r1,r2=map(int,input().split())
c1,c2=map(int,input().split())
d1,d2=map(int,input().split())
f1,f2,f3,f4=0,0,0,0
fc1=0
fc2=0
fc3=0
fc4=0
fc5=0
fc6=0
x3=0
x1=0
x2=0
x4=0
for i in range(1,10):
    fc1=0
    fc2=0
    fc3=0
    fc4=0
    fc5=0
    fc6=0
    x1=i
    for j in range(1,10):
        if x1+j==c1:
            x3=j
            f3=1
    for j in range(1,10):
        if x1+j==d1:
            x4=j
            f4=1
    x2=c2-x4
    if x3+x4==r2:
        fc2=1
    if x1+x2==r1:
        fc1=1
    if x1+x3==c1:
        fc3=1
    if x2+x4==c2:
        fc4=1
    if x1+x4==d1:
        fc5=1
    if x2+x3==d2:
        fc6=1
    if [fc1,fc2,fc3,fc4,fc5,fc6]==[1 for i in range(6)] and x1!=x2 and x2!=x3 and x3!=x4 and x4!=x1 and x1!=x3 and x4!=x2:
        break
#print([fc1,fc2,fc3,fc4,fc5,fc6])
if [fc1,fc2,fc3,fc4,fc5,fc6]==[1 for i in range(6)] and x1!=x2 and x2!=x3 and x3!=x4 and x4!=x1 and x1!=x3 and x4!=x2:
    print(x1,x2)
    print(x3,x4)
else:
    print(-1)
    
            
