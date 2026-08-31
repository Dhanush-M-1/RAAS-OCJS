for _ in range(int(input())):
    n = int(input())
    A = []
    for _ in range(n):
        A.append(input())
    cnt = 0
    ans = []
    if A[0][1] == A[1][0]:
        cur = A[0][1]
        if A[-1][-2] == cur:
            cnt += 1
            ans.append([n, n - 1])
        if A[-2][-1] == cur:
            cnt += 1
            ans.append([n - 1, n])
        print(cnt)
        for a in ans:
            print(*a)
    else:
        cur = A[0][1] + A[1][0] + A[-1][-2] + A[-2][-1]
        n1 = cur.count('1')
        if n1 == 2:
            if A[0][1] == '1':
                ans.append([1, 2])
            if A[1][0] == '1':
                ans.append([2, 1])
            if A[-2][-1] == '0':
                ans.append([n - 1, n])
            if A[-1][-2] == '0':
                ans.append([n, n - 1])
            print(2)
            for a in ans:
                print(*a)
        else:
            t = '1' if n1 == 1 else '0'
            if '1' in A[0][1] + A[1][0]:
                if A[0][1] == t:
                    ans.append([2, 1])
                else:
                    ans.append([1, 2])
            else:
                if A[-2][-1] == t:
                    ans.append([n, n - 1])
                else:
                    ans.append([n - 1, n])
            print(1)
            for a in ans:
                print(*a)