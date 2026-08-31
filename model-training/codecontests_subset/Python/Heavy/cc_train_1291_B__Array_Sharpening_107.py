kl = int(input())
for l in range(kl):

    n = int(input())
    s = [int(i) for i in input().split()]
    pr = 1
    if n == 1:
        print('Yes')
        continue
    #    if n==2:
    #        if s[0]!=s[1]:
    #            print('Yes')
    #        else:
    #            print('No')
    #        continue
    for i in range(n // 2):
        if s[i] < i or s[n - 1 - i] < i:
            print('No')
            pr = 0
            break
    if pr:
        if n % 2 == 0:
            if s[n // 2 - 1] == s[n // 2] and s[n // 2] == n // 2 - 1:
                print('No')
            else:
                print('Yes')
        else:
            if s[n // 2] >= n // 2:
                print('Yes')
            else:
                print('No')
