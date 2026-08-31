

def fn(qa, qb, qc, k):
    qa.sort()
    qb.sort()
    qc.sort()
    num = 0
    ia = ib = ic = 0
    na,nb,nc = len(qa),len(qb),len(qc)
    for i in range(k):
        if (nc == 0) or (ic >= nc):
            num += qa[ia] + qb[ib]
            ia += 1
            ib += 1
        elif (na == 0) or (nb == 0) or (ia >= na) or (ib >= nb):
            num += qc[ic]
            ic += 1
        else:
            if (qa[ia]+qb[ib]) < qc[ic]:
                num += qa[ia] + qb[ib]
                ia += 1
                ib += 1
            else:
                num += qc[ic]
                ic += 1
    print(num)


n,k = list(map(int, input().split(" ")))
qa,qb,qc = [],[],[]
ca = cb = 0
for i in range(n):
    t,a,b = list(map(int, input().split(" ")))
    if (a==1) and (b==1):
        ca += 1
        cb += 1
        qc.append(t)
    elif a==1:
        ca += 1
        qa.append(t)
    elif b==1:
        cb += 1
        qb.append(t)

if (ca < k) or (cb < k):
    print(-1)
else:
    fn(qa,qb,qc,k)
	 		  		     		  	 		   	  	 	