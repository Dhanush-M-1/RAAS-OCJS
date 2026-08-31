
import sys



def solution(a,b):

    total=0
    kalan=0
    while a>=1:
        total+=a
        kalan += a % b
        a//=b
        'print(kalan,"kalan")'
        while (kalan>=b):
            a+=1
            kalan-=b
        'print(a,"<<AAA")'

    return total



def main():
    n, m = map(int, sys.stdin.readline().strip().split(' '))
    print(solution(n,m))


if __name__ == "__main__":
    main()

