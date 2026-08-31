n , k = map(int,input().split())
arr = list(map(int,input().split()))
arr = list(reversed(sorted(arr)))

for i in arr :
    if k % i == 0 :
        print(k // i)
        exit()
