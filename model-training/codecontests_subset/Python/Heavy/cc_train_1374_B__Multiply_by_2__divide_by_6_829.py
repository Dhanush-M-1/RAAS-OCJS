def main():
    t=int(input())
    for _ in range(t):
        n=int(input())
        c=0
        if n==1:
            print(0)
            continue
        if n<6 :
            n*=2
            c+=1
        while n!=1 and (n%6==0 or (n*2)%6==0):
            while n%6==0:
                n=n//6
                c+=1
                #print(n)
            if n==1:
                break
            n=n*2
            c+=1
            #print(n)
        if n==1:
            print(c)
        else:
            print(-1)
main()
            
