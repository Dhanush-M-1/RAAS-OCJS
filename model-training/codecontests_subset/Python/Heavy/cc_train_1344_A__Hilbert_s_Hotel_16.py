from collections import Counter
def solve(t):
    n = int(input())
    arr = list(map(int, input().strip().split()))

    '''
    k + arr[k % n] == j + arr[j%n]
    k - j = arr[j%n] - arr[k%n]
    k - j = arr[ij] - arr[ik]
    (nx + ik) - (ny + ij) = arr[ij] - arr[ik]
    n*(x-y) + (ik - ij) == arr[ij] - arr[ik]

    if (arr[ij] - arr[ik]) % n == (ik - ij) % n => YES

    nx + arr[ik] + ik = ny + arr[ij] + ij

    (arr[ik] + ik) % n == (arr[ij] + ij) % n => YES

    '''
    ss = set()
    
    for i, num in enumerate(arr):
        rr = (num % n + i) % n
        if(rr in ss):
            print('NO')
            return
        else:
            ss.add(rr)
    print('YES')
    

if __name__ == '__main__':
    tc = int(input())

    for t in range(1, tc+1):
        solve(t)
