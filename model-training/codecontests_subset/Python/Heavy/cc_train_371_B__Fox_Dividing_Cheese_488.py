def gcd(a,b):
    if a == 0:
        return b
    return gcd(b % a, a)

def main():
    x,y=map(int,input().split(' '))
    eq = gcd(x,y)
    a,b=int(x/eq),int(y/eq)
    ans=0
    while True:
        if a%2==0:
            a=int(a/2)
            ans+=1
        if a%3==0:
            a = int(a/3)
            ans+=1
        if a%5==0:
            a=int(a/5)
            ans+=1
        if a%2!=0 and a%3!=0 and a%5!=0:
            if a!=1:
                print(-1)
                exit()
            if a==1:
                break
    while True:
        if b%2==0:
            b=int(b/2)
            ans+=1
        if b%3==0:
            b=int(b/3)
            ans+=1
        if b%5==0:
            b=int(b/5)
            ans+=1
        if b%2!=0 and b%3!=0 and b%5!=0:
            if b!=1:
                print(-1)
                exit()
            if b==1:
                break
    print(ans)


main()
