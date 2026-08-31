n,k = map(int, input().split())
a = list(map(int, input().split()))
a.sort(reverse=True)

for bucket in a:
    if k%bucket==0:
        print(k//bucket)
        exit(0)