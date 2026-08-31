a,b = list(map(int, input().split()))
m = 0
n = a
while(n!=0):
    m = m+1
    n = n-1
    if m%b==0:
        n=n+1
print(m)
