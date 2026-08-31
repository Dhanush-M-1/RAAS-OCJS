s = input().split()
n = int(s[0])
k = int(s[1])
m = k
s1 = input().split()
for i in range (n):
    if k % int(s1[i]) == 0:
        if k//int(s1[i]) < m:
            m = k//int(s1[i])
print(m)
