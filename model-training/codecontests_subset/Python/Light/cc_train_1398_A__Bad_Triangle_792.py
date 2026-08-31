for i in range(int(input())):
    n = int(input())
    A = list(map(int,input().split()))
    ans = []

    if (abs(A[0]-A[n-1])>=A[1]):
        ans.append(1)
        ans.append(2)
        ans.append(n)
    elif A[0] >= A[n-1]+A[n-2]:
        ans.append(1)
        ans.append(n-1)
        ans.append(n)
    else:ans.append(-1)
    print(' '.join(map(str, ans)))