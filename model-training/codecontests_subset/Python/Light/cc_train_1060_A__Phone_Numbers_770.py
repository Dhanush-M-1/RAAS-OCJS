n=int(input())
p=list(input())
s=0
pa=0
ta=0
for x in range(n):
    if int(p[x])==8:
        s+=1
    else:
        pa+=1
for y in range(5555):
    if pa>=10 and s>0:
        ta+=1
        pa-=10
        s-=1
    elif s==0:
        break
    elif s>0 and pa<10:
        if s+pa>=11:
            s-=11-pa
            pa=0
            ta+=1 
        else:
            break
print(ta)