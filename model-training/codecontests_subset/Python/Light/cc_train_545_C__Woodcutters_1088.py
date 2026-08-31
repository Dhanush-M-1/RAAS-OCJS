n = int(input())
m = {}
for i in range(n):
    x,h = input().split()
    m[int(x)] = int(h)
ans = 0
if n >= 2: ans = 2;
else: ans = 1
a = list(m.keys());
right = a[0]
for i in range(1,len(a) - 1):
    #print(right)
    if a[i] - right > m[a[i]]:
        #print(i)
        ans += 1; right = a[i]
    elif a[i + 1] - a[i] > m[a[i]]:
        #print(i)
        ans += 1; right = a[i] + m[a[i]];
    else: right = a[i]
print(ans)
    
