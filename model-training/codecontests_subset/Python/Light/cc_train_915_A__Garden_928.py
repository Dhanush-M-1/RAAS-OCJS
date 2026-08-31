N,K = map(int,input().split())
src = list(map(int,input().split()))
for a in reversed(sorted(src)):
    if a > K: continue
    if K%a == 0:
        print(K//a)
        exit()
