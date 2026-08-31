t = int(input().strip())
for _ in range(t):
    n,m = map(int,input().strip().split())
    #nums = [int(i) for i in input().strip().split()]
    s = input().strip()
    ps = [int(i) - 1 for i in input().strip().split()]
    cnts = [0 for i in range(26)]
    pre = 0
    ps.sort()
    for cnt,i in enumerate(ps):
        #print(s[i])
        for j in range(pre,i + 1):
            #print('s[j]: ',s[j])
            #print(ord(s[j]) - ord('a'))
            cnts[ord(s[j]) - ord('a')] += (m - cnt) + 1
        pre = i + 1
    if pre < n:
        for j in range(pre,n):
            cnts[ord(s[j]) - ord('a')] +=  1
                
    print(' '.join(str(i) for i in cnts))
