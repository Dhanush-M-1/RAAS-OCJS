nm=[int(i) for i in input().split()]
n=nm[0]
m=nm[1]
runout=0
hours=0
while n!=0:
    hours+=n
    runout+=n
    n=runout//m
    runout-=runout//m*m
print(hours)