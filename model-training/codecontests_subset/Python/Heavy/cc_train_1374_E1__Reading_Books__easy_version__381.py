n,k=map(int,input().split())

A = []
B = []
AB = []

for i in range(n):
    t,a,b = map(int,input().split())
    if a==1 and b==0:
        A.append(t)
    if b==1 and a==0:
        B.append(t)
    if a==1 and b==1:
        AB.append(t)

A.sort()
B.sort()
AB.sort()

ia = 0
ib = 0
iab = 0

kab = 0
total_time = 0

while(True):
    if (iab > len(AB)-1) and (ia > len(A)-1 or ib > len(B)-1):
        print(-1)
        break
    if iab <= len(AB)-1:
        if (ia > len(A)-1 or ib > len(B)-1):
            total_time += AB[iab]
            kab +=1
            if kab == k:
                print(total_time)
                break
            iab += 1
        else:
            if AB[iab]<A[ia]+B[ib]:
                total_time += AB[iab]
                kab +=1
                if kab == k:
                    print(total_time)
                    break
                iab += 1
            else:
                total_time += (A[ia]+B[ib])
                kab +=1
                if kab == k:
                    print(total_time)
                    break
                ia += 1        
                ib += 1        
    else:
        total_time += (A[ia]+B[ib])
        kab +=1
        if kab == k:
            print(total_time)
            break
        ia += 1        
        ib += 1         
