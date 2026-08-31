n, k = [int(i) for i in input().split()]
S = [int(i) for i in input().split()]
for i in sorted(S, reverse=1):
    if k%i == 0:
        print(k//i)
        break
