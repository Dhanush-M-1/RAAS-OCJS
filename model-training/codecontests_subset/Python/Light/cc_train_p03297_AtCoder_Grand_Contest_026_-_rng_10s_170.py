from fractions import gcd
def main():
    T=int(input())
    for _ in range(T):
        A,B,C,D=map(int, input().split())
        ans=True
        if B>D or B>A:
            ans=False
        elif B<=C:
            pass
        else:
            i=A%B
            if C<i:
                ans=False
            g=gcd(B,D)
            if g and not ((C-i)//g*g+i<=C and B<=(C-i)//g*g+i+g):
                ans=False
        print("YNeos"[not ans::2])

if __name__ == "__main__":
    main()