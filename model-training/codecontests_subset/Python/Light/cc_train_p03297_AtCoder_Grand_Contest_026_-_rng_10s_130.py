def main():
    from fractions import gcd
    n=int(input())
    for _ in range(n):
        a,b,c,d=list(map(int,input().split()))
        if a<b or b>d:
            print("No")
            continue
        k=(a-c-1)//b+1
        e=a-b*k
        if e<0:
            print("No")
            continue
        if b<=c+1 and b<=d:
            print("Yes")
            continue
        g=gcd(b,d)
        if b-c>g:
            print("No")
        else:
            print("Yes")
main()
