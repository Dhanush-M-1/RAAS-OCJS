if __name__ == '__main__':
    T=int(input())
    for t in range(T):
        n=int(input())
        L=list(map(int,input().split()))
        b=0
        d=L[n-1]-L[0]
        for i in range(1,n):
            if(L[i]<=d):
                print(str(1)+" "+str(i+1)+" "+str(n))
                b=1
                break
        if(b==0):
            print("-1")