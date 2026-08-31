n = int(input())
a = list(map(int,input().split()))
odd = []
even = []
odd.reverse()
even.reverse()
cnt = 1
for i in range(n):
    if a[i] == 0:cnt += 1
    if a[i] % 2 == 0:odd.append(a[i])
    else:even.append(a[i])
    
even.sort()
odd.sort()

n = len(odd)
m = len(even)

if abs(n - m) <= cnt:
    print(0)
    exit()
    
if m == 0:
    print(sum(odd) - odd[-1])
    exit()
    
elif n == 0:
    print(sum(even) - even[-1])
    exit()
    
if n > m:
    print(sum(odd[:n - m - 1]))
else:
    print(sum(even[:m - n - 1]))
