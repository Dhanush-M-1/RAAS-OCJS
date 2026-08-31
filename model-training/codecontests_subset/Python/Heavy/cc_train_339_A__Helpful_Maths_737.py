alist=input()
alist=list(alist)
alist=alist[0::2]
b=len(alist)
if b==1:
    for i in alist:
        print(i, end="")
def smartBubbleSort(alist):
    n = len(alist)
    exchanges = True
    for passnum in range( n-1 , 0 , -1 ):
        if exchanges == False:
            break
        exchanges=False
        for i in range(passnum):
            if alist[i] > alist[i+1]:
                alist[i] , alist[i+1] = alist[i+1] , alist[i]
                exchanges = True
smartBubbleSort(alist)
def printInc( b ,alist):
    a = ["+"]
    p = []
    for g in range(b):
        if b>0 and b!=1:
            p += str(alist[g])
            p += a
        else:
            if b>0 and b==1:
                p += str(alist[g])
    return p
u=printInc(b,alist)
del u[-1]
for i in u:
    print(i,end="")
