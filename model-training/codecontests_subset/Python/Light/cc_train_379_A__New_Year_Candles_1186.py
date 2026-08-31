a,b = [int(x) for x in input().split()]
total=0
cura,curb=a,0
while cura>=b:
    shift = cura%b
    cura,curb=cura-shift,curb+shift
    total+=cura
    cura=cura//b
    if cura<b:
        cura+=curb
        curb=0
total+=cura
print(total)
