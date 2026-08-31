lt=list(input().split())
r1,r2=int(lt[0]),int(lt[1])
lt=list(input().split())
c1,c2=int(lt[0]),int(lt[1])
lt=list(input().split())
d1,d2=int(lt[0]),int(lt[1])
Sw=0
for i00 in range(1,10):
    for i01 in range(1,10):
        if i00==i01:
            continue
        for i10 in range(1,10):
            if i10==i01 or i10==i00:
                continue
            for i11 in range(1,10):
                if i11==i10 or i11==i01 or i11==i00:
                    continue
                if i00+i01==r1 and i10+i11==r2 and i00+i11==d1 and i01+i10==d2 and i00+i10==c1 and i01+i11==c2:
                    Sw=1
                    print(i00,i01)
                    print(i10,i11)
if Sw==0:
    print(-1)
