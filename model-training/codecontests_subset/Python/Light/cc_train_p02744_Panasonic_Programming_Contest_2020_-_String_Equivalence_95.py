n=int(input())
def dsf(s,k):
    if len(s)==n:
        print(s)
    else:
        for i in range(k):
            dsf(s+chr(i+97),k)
        dsf(s+chr(k+97),k+1)
dsf("",0)