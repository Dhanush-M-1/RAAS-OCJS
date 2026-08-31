def main():
        n,k=[int(i) for i in input().split()]
        a=[int(i) for i in input().split()]
        a.sort()
        if a[n//2]==k:
                return 0
        if n==1:
                return abs(a[0]-k)
        c=abs(a[n//2]-k)
        i=1
        while(i<=n//2 and k>a[n//2+i]):
                c=c+abs(a[n//2+i]-k)
                i=i+1
        i=1
        while(i<=n//2 and k<a[n//2-i]):
                c=c+abs(a[n//2-i]-k)
                i+=1
        return c
print(main())
                
