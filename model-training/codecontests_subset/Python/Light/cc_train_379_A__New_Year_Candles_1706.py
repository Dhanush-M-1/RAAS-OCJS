N,k = map(int,input().split())
hours = N
while N>=k:
    x = N%k
    N = N//k
    hours += N
    N+=x
print(hours)