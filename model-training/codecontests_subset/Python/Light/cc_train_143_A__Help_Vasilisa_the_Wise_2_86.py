r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())

tl, tr ,bl, br = 0,0,0,0

satisfied = False
counter = 1

if max(r1,r2,c1,c2,d1,d2) > 8+9:
    counter = 10
    
while (counter < 10 and not satisfied):
    tl = counter
    tr = r1 - tl
    bl = c1 - tl
    br = d1 - tl

    if (r2 == bl + br and c2 == tr + br and d2 == bl + tr and len({tl,tr,bl,br}) == 4 
    and 0<tr<10 and 0<bl<10 and 0<br<10):
        satisfied = True
    counter+=1

if satisfied:
    print(tl, tr, '\n'+str(bl), br)
else:
    print(-1)