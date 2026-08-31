def sol():
    n=int(input())
    A=[]
    for i in range(n):
        A.append(int(input()))
    l=3
    op=3
    for i in range(0,n):
        if(i==0):
            if(A[i]==3):
                print("NO")
                return
            else:
                l=3-A[i]
                op=3
        else:
            if(A[i]==l):
                print("NO")
                return
            else:
                l=6-A[i]-l
                op=A[i]
        #print(A[i],op,l)
    print("YES")
if(__name__=='__main__'):
    sol()
