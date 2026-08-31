def sol():
    n,k=map(int,input().split())
    A=[int(i)for i in input().split()]
    p=0
    for i in range(1,k+1):
        if(k%i==0 and i in A):
            p=i
    print(k//p)
if(__name__=='__main__'):
    sol()
