s = input().split()
n = int(s[0])
m = int(s[1])
d = {str(i):i for i in range(1,m+1)}
for _ in range(n):
    l = input().split()
    for i in range(1, len(l)):
        if l[i] in d:
            del d[l[i]]
print(('YES' if len(d) == 0 else 'NO'))
