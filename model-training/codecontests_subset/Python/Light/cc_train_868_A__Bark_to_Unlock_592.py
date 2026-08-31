
s1 = input()
n = int(input())

begs = set()
ends = set()

res = False

for i in range(0, n):
    s = input()
    if s == s1:
        res = True
    begs.add(s[0])
    ends.add(s[1])

res = res or (s1[0] in ends and s1[1] in begs)

print('YES' if res else 'NO')
