a = input().split()
print(*a)
n = int(input())
#n, m = map(int, input().split())
#s = input()
#c = list(map(int, input().split()))
for i in range(n):
    s = input().split()
    a[a.index(s[0])] = s[1]
    print(*a)
    