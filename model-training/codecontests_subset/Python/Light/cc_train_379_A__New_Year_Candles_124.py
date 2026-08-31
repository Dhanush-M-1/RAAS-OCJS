
a=list(map(int,input().split(' ')))
time=0
used=0
while True:
    time+=a[0]
    used+=a[0]
    a[0]=0
    if used>=a[1]:
        a[0]+=int(used/a[1])
        used=used%a[1]
    else:
        break
print(time)