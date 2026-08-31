import sys
input = sys.stdin.readline
t = int(input())
for i in range(t):
    n = int(input())
    A = list(map(int,input().split()))
    no = 0

    if n % 2 == 1:
        B = [i for i in range(n//2)] + [n//2] + [i for i in range(n//2-1, -1, -1)]
        # print(B)
        for i in range(n):
            if A[i] < B[i]:
                no = 1
                break
    else:
        B = [i for i in range(n//2)] + [i for i in range(n//2-1, -1, -1)]
        
        B[n//2] += 1
        C = B[::-1]
        # print(B,C)
        for i in range(n):
            if A[i] < B[i]:
                no += 1
                break
        for i in range(n):
            if A[i] < C[i]:
                no += 1
                break
        if no==2:
            no = 1
        else:
            no = 0


    if no == 1:
        print("No")
    else:
        print("Yes")