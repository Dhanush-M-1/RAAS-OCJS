def sol():
    n=int(input())
    A=[int(i) for i in input().split()]
    B=[int(i) for i in input().split()]
    C=[int(i) for i in input().split()]
    print(sum(A)-sum(B))
    print(sum(B)-sum(C))
if(__name__=='__main__'):
    sol()
