def sol():
    a,b=map(int,input().split())
    p=a
    i=0
    while(i+b<=a):
        a+=1
        i+=b
        #print(i,a)
    print(a)
if(__name__=='__main__'):
    sol()
