t = int(input())

for _ in range(t):
    n = int(input())
    al = list(map(int,input().split()))
    if n % 2 == 1:
        for idx, a in enumerate(al):
            if a < min(idx, n-idx-1):
                print("No")
                break
        else:
            print("Yes")
    elif n % 2 == 0:
        for idx , a in enumerate(al):
            if idx <= (n // 2):
                k = idx
            else:
                k = n-idx-1
            if a < k:
                a1 = 0
                break
        else:
            a1 = 1

        for idx , a in enumerate(al):
            if idx <= (n // 2 - 2):
                k = idx
            else:
                k = n-idx-1
            if a < k:
                a2 = 0
                break
        else:
            a2 = 1

        if a1 == 0 and a2 == 0:
            print("No")
        else:
            print("Yes")
