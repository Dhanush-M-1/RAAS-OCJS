from bisect import bisect_right
N=10**6
n=int(input())
a=list(map(int, input().split()))
i=bisect_right(a, N//2)
print(max(a[i-1]-1if i else 0,N-a[i]if i<n else 0))