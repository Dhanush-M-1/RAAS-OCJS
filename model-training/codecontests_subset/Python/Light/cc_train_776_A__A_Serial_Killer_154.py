a,b = input().split()
print(a,b)
n = int(input())
for _ in range(n):
    s1,s2 = input().split()
    if a==s1:
        a = s2
    else:
        b = s2
    print(a,b)