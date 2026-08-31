a=list(map(int,input().split()))
can=a[0]
hou=0
while True:
    can-=1
    hou+=1
    if hou%a[1]==0:
        can+=1
    if can==0:
        break
print(hou)
