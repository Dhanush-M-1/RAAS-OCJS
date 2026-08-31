#Bhargey Mehta (Junior)
#DA-IICT, Gandhinagar
import sys, math, queue, collections
MOD = 10**9+7
#sys.stdin = open('input.txt', 'r')

for _ in range(int(input())):
    s, t = input().strip().split()
    ss = list(s)
    for i in reversed(range(len(s)-1)):
        ss[i] = min(ss[i], ss[i+1])
    for i in range(len(s)):
        if s[i] != ss[i]:
            j = max(filter(lambda x: s[x] == ss[i], list(range(len(s)))))
            s = s[:i]+s[j]+s[i+1:j]+s[i]+s[j+1:]
            break
    if s >= t:
        print('---')
    else:
        print(s)