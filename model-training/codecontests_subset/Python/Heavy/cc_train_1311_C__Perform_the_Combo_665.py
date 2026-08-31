# cook your dish here
for _ in range(int(input())):
    n,m = [int(x) for x in input().split()]
    s =input()
    p = [int(x) for x in input().split()]
    p.sort()
    alpha = [0]*26
    pre = m
    j = 0
    for i in range(0,m):
        while(j<n and j<p[i]):
            alpha[ord(s[j])-ord('a')]+= pre;
            j += 1 
        pre -= 1 
        
    j = 0
    while(j<n):
        alpha[ord(s[j])-ord('a')] += 1 
        j += 1 
    for i in range(26):
        if(i==25):
            print(alpha[i])
        else:
            print(alpha[i],end=" ")
