def main():
    for _ in range(int(input())):
        n=int(input())
        A=[int(e) for e in input().split()]
        i=0
        j=1
        k=n-1
        # while k>j:
        if A[i]+A[j]<=A[k]:
            print(i+1,j+1,k+1)
        else:
            print(-1)
main()
