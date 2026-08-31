t = int(input())

for ii in range(t):
    n , m = map(int,input().split())
    s = input()
    l = list(map(int,input().split()))
    suffix_sum = [0] * n
    res = [0] * 26

    for i in l :
        suffix_sum[i - 1] +=1

    #print(suffix_sum)
    i = n - 2
    while i >= 0 :
        suffix_sum[i] += suffix_sum[i + 1 ]
        i -=1

    i = 0
    while i < n :
        suffix_sum[i] +=1
        i +=1

    for i in range(n):
        c = ord(s[i]) - ord('a')
        res[c] += suffix_sum[i]

    print(*res)