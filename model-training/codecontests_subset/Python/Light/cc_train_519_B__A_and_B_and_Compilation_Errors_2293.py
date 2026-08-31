t = int(input())
a = sorted(map(int, input().split()))
b = sorted(map(int, input().split()))
c = sorted(map(int, input().split()))
s = []
for i in range(t-1):
    if a[i] != b[i]:
        s.append(a[i])
        break
if len(s) == 0:
    s.append(a[-1])
for i in range(t-2):
    if b[i] != c[i]:
        s.append(b[i])
        break
if len(s) == 1:
    s.append(b[-1])
print(' \n'.join([str(elem) for elem in s]))
