rs = input().strip().split(' ')
cs = input().strip().split(' ')
ds = input().strip().split(' ')

r1 = int(rs[0])
r2 = int(rs[1])
c1 = int(cs[0])
c2 = int(cs[1])
d1 = int(ds[0])
d2 = int(ds[1])


if min(r1, r2, c1, c2, d1, d2)==1:
    print(-1)
else:
    row1 = []
    k = 1
    while r1-k>0:
        if k!=r1-k and k<=9 and r1-k<=9:
            row1.append([k, r1-k])
        k+=1
    row2 = []
    k = 0 
    while k<len(row1):
        r21 = c1-row1[k][0]
        r22 = c2-row1[k][1]
        if r21>0 and r22>0 and r21<=9 and r22<=9 and r21+r22==r2 and r21+row1[k][1]==d2 and r22+row1[k][0]==d1 and len(set([r22, r21]+row1[k]))==4:
            row2.append([r21, r22])
            k += 1
        else:
            row1.pop(k)
    
    if len(row1)>0:
        print(row1[0][0], row1[0][1])
        print(row2[0][0], row2[0][1])
    else:
        print(-1)
         
         
         
             
        
        