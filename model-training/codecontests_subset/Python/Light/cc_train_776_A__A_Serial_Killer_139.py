s, p = input().split()
n = int(input())
print(s, p, sep=' ', end='\n')
for i in range(n):
    s1, s2 = input().split()
    p, s = s if s1 == p else p, s2
    print(s, p, sep=' ', end='\n')