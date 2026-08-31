'''
the value need to be >= min(i, len(lst) - i-1)
if even, the max of middle two need to be larger than the index of n//2

'''
def solve(lst):
    for i in range(len(lst)):
        if lst[i] < min(i, len(lst) - i - 1):
            return False

    n = len(lst)
    if n % 2 == 0:
        return max(lst[n//2-1], lst[n//2]) > n//2 -1
    return True

m = int(input())
for _ in range(m):
    n = input()
    lst = list(map(int, input().split()))
    if solve(lst):
        print('YES')
    else:
        print('NO')
