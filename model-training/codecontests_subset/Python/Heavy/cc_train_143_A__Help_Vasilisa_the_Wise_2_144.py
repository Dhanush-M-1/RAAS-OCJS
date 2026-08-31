r1,r2 = input().split(" ")
c1,c2 = input().split(" ")
d1,d2 = input().split(" ")
r1,r2,c1,c2,d1,d2 = int(r1),int(r2),int(c1),int(c2),int(d1),int(d2)
ar1 = []
z = True
m = max(c1,c2)
if(r1+r2 == c1+c2 == d1+d2):
    for n in range((r1-1)//2):
        ar1.append([r1-1-n,1+n])
    for n in ar1:
        if n[0] < 10 and n[0] <= m:
            ar2 = []
            ar2.append(c1-n[0])
            ar2.append(r2-ar2[0])
            if(n[0] == ar2[0] or n[1] == ar2[1] or ar2[0] == ar2[1] or n[0] == ar2[1] or n[1] == ar2[0]):
                n[0],n[1] = n[1],n[0]
                ar2 = []
                ar2.append(c1-n[0])
                ar2.append(r2-ar2[0])
                if not (n[0] == ar2[0] or n[1] == ar2[1] or ar2[0] == ar2[1] or n[0] == ar2[1] or n[1] == ar2[0]):
                    if(n[0]+ar2[1] == d1 and n[1] + ar2[0] == d2 and ar2[0] < 10 and ar2[1] < 10 and ar2[0] > 0 and ar2[1] > 0):
                        print(n[0],n[1])
                        print(ar2[0],ar2[1])
                        z = False
                        break
            else:
                if(n[0]+ar2[1] == d1 and n[1] + ar2[0] == d2 and ar2[0] < 10 and ar2[1] < 10 and ar2[0] > 0 and ar2[1] > 0):
                    print(n[0],n[1])
                    print(ar2[0],ar2[1])
                    z = False
                    break
                else:
                    n[0],n[1] = n[1],n[0]
                    ar2 = []
                    ar2.append(c1-n[0])
                    ar2.append(r2-ar2[0])
                    if not(n[0] == ar2[0] or n[1] == ar2[1] or ar2[0] == ar2[1] or n[0] == ar2[1] or n[1] == ar2[0]):
                        if(n[0]+ar2[1] == d1 and n[1] + ar2[0] == d2 and ar2[0] < 10 and ar2[1] < 10 and ar2[1] > 0 and ar2[0] > 0):
                            print(n[0],n[1])
                            print(ar2[0],ar2[1])
                            z = False
                            break
    if z:
        print("-1")
else:
    print("-1")