if True:
    N = int(input())
    As = list(map(int, input().split()))

    maxA = 10**6 + 6
    c = [0] * (maxA+1)
    for A in As:
        c[A] += 1
    isPrime = True
    cnt = 0
    for i in range(2, maxA+1):
        cnt = sum(c[i::i])
        if cnt == N:
            # Asはすべてiの約数
            print("not coprime")
            break
        if cnt >= 2:
            isPrime = False
        
    else:
        if isPrime:
            print("pairwise coprime")
        else:
            print("setwise coprime")



