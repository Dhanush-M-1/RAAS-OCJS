t = int(input())
test_cases = [[input() for j in range(3)] for i in range(t)]

P = []

def binary_search(ok, ng, func):
    while abs(ok-ng) > 1:
        mid = (ok+ng) // 2
        if func(mid):
            ok = mid
        else:
            ng = mid
    return ok

def solve(test_case):
    n,m = map(int, test_case[0].split())
    s = test_case[1]
    P = list(map(int, test_case[2].split()))
    P.sort(reverse=True)
    P.append(-1)

    s_arr = [ord(c) - ord('a') for c in s]
    
    ans = [0 for i in range(26)]

    for i in range(n):
        k = binary_search(-1,m,lambda x: P[x] >= i+1)
        ans[s_arr[i]] += k + 2
    
    print(' '.join(map(str,ans)))

for test_case in test_cases:
    solve(test_case)
