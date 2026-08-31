def main():
    t=int(input ())
    for tt in range (t):
        n=int(input ())
        a=list(map(int,input().split()))
        if(a[0]+a[1]<=a[len(a)-1]):
            print (1,2,len(a))
        else:
            print (-1)
main()