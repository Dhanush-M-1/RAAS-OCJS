input()
s = list(input())
if len(s) < 11 or s.count('8') == 0:
    print(0)
    exit(0)
s.sort()
a = [i for i in range(len(s)) if s[i] == '8']
s[a[0]:a[-1]+1] = []
for _ in range(len(a)): s.append('8')
cnt = 0
while len(s) >= 11:
    if s.count('8') == 0: break
    s.remove('8')
    s[0:10] = []
    cnt += 1
print(cnt)