s1,s2 = input().split()

n = int(input())
for i in range(n):
    print(s1,s2)
    s,c = input().split()
    if s == s1:
        s1 = c
    else:
        s2 = c
print(s1,s2)
