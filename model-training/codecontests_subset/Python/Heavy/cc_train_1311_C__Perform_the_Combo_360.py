import string
alph = list(string.ascii_lowercase)

from bisect import bisect_right
def find_gt(a, x):
    'Find leftmost index greater than x'
    i = bisect_right(a, x)
    return i
    #raise ValueError


t = int(input())
for _ in range(t):
    d = {each:0 for each in alph}
    n, m = list(map(int, input().split()))
    s = input()
    p = sorted(list(map(int, input().split())))
    
    #print(p)

    for i, ch in enumerate(s):
        #print(i)
        temp = find_gt(p, i)
        d[ch] += m + 1 - temp

    print(" ".join(map(str, d.values())))
    

