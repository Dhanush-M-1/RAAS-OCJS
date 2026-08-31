import sys

p = int(sys.stdin.readline().strip())
ans = []

def findMinimum(lst):
    lo = 'a'
    for k in range(len(lst)):
        if lst[k] <= lo:
            lo = lst[k]
            idx = k
    return lo, idx

for i in range(p):
    m, n = sys.stdin.readline().strip().split(' ')
    m = list(m)
    n = list(n)
    objduplicate = m[:]
    if m < n:
        ans.append(''.join(m))
        continue
    for p in range(len(m)-1):
        lo, idx = findMinimum(m[p+1:])
        if lo < m[p]:
            m[idx+p+1], m[p] = m[p], m[idx+p+1]
            break
    if m < n:
        ans.append(''.join(m))
    else:
        ans.append('---')

for i in ans:
    sys.stdout.write(i + '\n')
# AVNMRMRNRMRRNNUM 
# AMNMRMRNRMRRNNUVA