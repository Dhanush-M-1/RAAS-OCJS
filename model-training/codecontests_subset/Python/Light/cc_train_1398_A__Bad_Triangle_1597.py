def solve(n, lst):
    if lst[0]+lst[1]>lst[-1]:
        return -1
    else:
        return '1 2 '+str(n)
t = int(input())
for _ in range(t):
    n = int(input())
    lst = list(map(int, input().split(' ')))
    print(solve(n, lst))
    
