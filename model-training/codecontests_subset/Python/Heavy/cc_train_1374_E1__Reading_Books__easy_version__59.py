n, k = [int(i) for i in input().split()]

doub = []; a = []; b = []
for i in range(n):
    ti, ai, bi = [int(i) for i in input().split()]

    if ai and bi:
        doub.append(ti)
    
    elif ai:
        a.append(ti)
    
    elif bi:
        b.append(ti)

doub.sort(); a.sort(); b.sort()
# print(doub, a, b, sep="\n")

time = 0

i = 0; j = 0
while i+j < k:
    if (i < len(doub)):
        db = doub[i]
    else:
        db = 100000
    if (j < len(a) and j < len(b)):
        sing = a[j] + b[j]
    else:
        sing = 100000
    
    if (db <= sing):
        time += db
        i += 1 
    else:
        time += sing
        j += 1

if (len(doub) + min(len(a), len(b))) >= k:
    print(time)
else:
    print(-1)



