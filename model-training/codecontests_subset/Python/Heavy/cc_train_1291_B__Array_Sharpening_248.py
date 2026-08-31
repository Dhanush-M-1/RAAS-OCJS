ans = []
for _ in range(int(input())):
    n = int(input())
    u = list(map(int, input().split()))
    d = [0] * n
    #1 - left, 2 - right, 3 - both, 0 - none
    left = 0
    right = 0
    both = 0
    for i in range(n):
        if u[i] >= i and u[i] >= n - i - 1:
            d[i] = 3
            both += 1
        elif u[i] >= i:
            d[i] = 1
            left += 1
        elif u[i] >= n - i - 1:
            d[i] = 2
            right += 1
    if 0 in d:
        ans.append('No')
        continue
    L = 0
    R = 0
    B = 0
    for i in range(n):
        if d[i] == 1:
            L += 1
        elif d[i] == 2:
            R += 1
        else:
            if L == left and R == 0:
                ans.append('Yes')
                break
    else:
        ans.append('No')
print('\n'.join(ans))
    
