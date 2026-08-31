l1 = input().split(' ')
n = int(l1[0])
k = int(l1[1])

alike = 0
blike = 0
total = 0
tboth = []
ta = []
tb = []
for i in range(n):
    b = input().split(' ')
    time = int(b[0])
    alice = int(b[1])
    bob = int(b[2])
    if alice:
        alike += 1
    if bob:
        blike += 1
    if alice and bob:
        tboth.append(time)
    if alice and not bob:
        ta.append(time)
    if not alice and bob:
        tb.append(time)
if alike<k or blike<k:
    print (-1)
else:
    import heapq
    heapq.heapify(tboth)
    heapq.heapify(ta)
    heapq.heapify(tb)
    alike = blike = k
    while alike > 0 or blike > 0:
        a = b = o = False
        if tboth:
            mo = heapq.heappop(tboth)
            o = True
        if ta:
            ma = heapq.heappop(ta)
            a = True
        if tb:
            mb = heapq.heappop(tb)
            b = True
        if a and b and o:
            mi = min(ma+mb,mo)
            total += mi
            if mi == mo:
                heapq.heappush(ta,ma)
                heapq.heappush(tb,mb)
            else:
                heapq.heappush(tboth,mo)
            alike -=1 
            blike -=1
        elif a and b:
            total += (ma+mb)
            alike -=1 
            blike -=1
        elif o:
            total += mo
            alike -=1 
            blike -=1
        elif a:
            total += ma
            alike -= 1
        elif b:
            total += mb
            blike -= 1
    print (total)
            
        
