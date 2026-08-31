n,k = map(int,input().split())
a = []
b = []
c = []
for i in range(n):
    x,y,z = map(int,input().split())
    if y == 1 and z != 1:
        a.append(x)
    elif y != 1 and z == 1:
        b.append(x)
    elif y == 1 and z == 1:
        c.append(x)
    else:
        pass
if len(a)+len(c)<k or len(c)+len(b)<k:
    ans = -1
else:
    a.sort()
    b.sort()
    c.sort()
    pt1,pt2,pt3 = 0,0,0
    move1 = 0
    move2 = 0
    ans = 0
    while True:
        if len(c) == 0:
            for i in range(k):
                ans += a[i]
            for i in range(k):
                ans += b[i]
            break
        else:
            if move1 == k and move2 == k:
                break
            elif move1<k and move2 == k:
                if pt1<len(a) and pt3<len(c):
                    if a[pt1]<c[pt3]:
                        ans += a[pt1]
                        pt1 += 1
                    else:
                        ans += c[pt3]
                        pt3 += 1
                elif not(pt1<len(a)) and pt3<len(c):
                    ans += c[pt3]
                    pt3 += 1
                else:
                    ans += a[pt1]
                    pt1 += 1
                move1 += 1

            elif move1 == k and move2<k:
                if pt2<len(b) and pt3<len(c):
                    if b[pt2]<c[pt3]:
                        ans += b[pt2]
                        pt2 += 1
                    else:
                        ans += c[pt3]
                        pt3 += 1
                elif not(pt2<len(b)) and pt3<len(c):
                    ans += c[pt3]
                    pt3 += 1
                else:
                    ans += b[pt2]
                    pt2 += 1
                move2 += 1
            else:
                if pt1<len(a) and pt2<len(b) and pt3<len(c):
                    if a[pt1]+b[pt2]<c[pt3]:
                        ans += a[pt1]
                        move1 += 1
                        ans += b[pt2]
                        move2 += 1
                        pt1 += 1
                        pt2 += 1
                    else:
                        ans += c[pt3]
                        move1 += 1
                        move2 += 1
                        pt3 += 1
                else:
                    if pt3<len(c):
                        ans += c[pt3]
                        pt3 += 1
                        move1 += 1
                        move2 += 1
                    else:
                        if pt1<len(a):
                            ans += a[pt1]
                            pt1 += 1
                            move1 += 1
                        if pt2<len(b):
                            ans += b[pt2]
                            pt2 += 1
                            move2 += 1                  
print(ans)
                    
                    
                
                
                    
                    
                
    
