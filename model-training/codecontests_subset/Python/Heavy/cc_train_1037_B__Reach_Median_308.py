import math
n, s = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
#print(arr)
pref = [0]
for i in arr:
    pref.append(pref[-1] + i)
    
l = -1
r = n
while r - l > 1:
    m = (r + l) // 2
    if arr[m] > s:
        r = m
    else:
        l = m
i = r - 1
if i >= n // 2:
    need = s * (i - n // 2 + 1)
    print(abs(need - pref[i + 1] + pref[n // 2]))
else:
    i += 1
    need = s * (n // 2 - i + 1)
    print(abs(pref[n // 2 + 1] - pref[i] - need))    
#n = int(input())
#print(math.ceil(math.log2(n + 1)))