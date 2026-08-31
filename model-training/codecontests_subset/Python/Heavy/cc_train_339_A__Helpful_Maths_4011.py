listNumber = list(map(int,input().split('+')))
def mergesort(listA, n):
    if(n>1):
        nL =n//2
        nR = n - nL
        L = listA[:nL]
        R = listA[nL:]
        mergesort(L, nL)
        mergesort(R, nR)
        merge(listA,L, nL, R, nR)
def merge(a,L,nL,R,nR):
    i = 0
    j = 0
    k = 0
    while(i< nL and j < nR):
        if L[i] < R[j]:
            a[k] = L[i]
            i = i + 1
        else:
            a[k] = R[j]
            j = j + 1
        k = k + 1
    while(i <nL):
        a[k] = L[i]
        i = i + 1
        k = k + 1
    while(j <nR):
        a[k] = R[j]
        j = j + 1
        k = k + 1
mergesort(listNumber, len(listNumber))
for x in range(len(listNumber)-1):
    print(listNumber[x],end='+')
print(listNumber[-1])