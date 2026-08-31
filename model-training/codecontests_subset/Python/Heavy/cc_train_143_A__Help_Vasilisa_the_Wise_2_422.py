r=input().split()
c=input().split()
d=input().split()
def chick_list(l):
    if l[0]+l[1]==int(r[0]) and l[2]+l[3]==int(r[1]) and l[0]+l[2]==int(c[0]) and l[1]+l[3]==int(c[1]) and l[0]+l[3]==int(d[0]) and l[1]+l[2]==int(d[1]):
        return 1
    return 0    

ll=[0, 0, 0, 0]

for i in range(1,10):
    ll[0] = i
    for j in range(1,10):
        if i==j:
            continue 
        ll[1] = j
        for k in range(1,10):
            if k==j or k==i:
                continue
            ll[2]=k
            for m in range(1,10):
                if m==k or m==j or m==i:
                    continue
                ll[3]=m
                if chick_list(ll)==1:
                    print(ll[0],' ',ll[1] ,'\n' ,ll[2],' ',ll[3],sep='')
                    exit()
print('-1')                        
