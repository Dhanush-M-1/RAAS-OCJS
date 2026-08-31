def fctr1(n): 
    f=[]
    c=0
    r=int(n**0.5)
    for i in range(2,r+2):
        while n%i==0:
            c+=1
            n=n//i
        if c!=0:
            f.append([i,c])
            c=0
    if n!=1:
        f.append([n,1])
    return f

def main():
    N, P = map(int, input().split())
    if N == 1:
        print(P)
        exit()
    if P == 1:
        print(1)
        exit()
    A = fctr1(P)
    cnt = 1
    for i, j in A:
        if j >= N:
            cnt *= i ** (j // N)

    print(cnt)


if __name__ == "__main__":
    main()