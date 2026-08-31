m,n=[int(x) for x in input().split()]
set0 = set()
set1 = set(str(i+1) for i in range(n))
for i in range(m):
    set0 = set0|set(input().split()[1:])
print(['YES','NO'][set0 != set1])