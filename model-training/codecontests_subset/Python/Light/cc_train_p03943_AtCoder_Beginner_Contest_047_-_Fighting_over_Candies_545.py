a=list(map(int,input().split()))
m=max(a)
print('Yes' if m*2==sum(a) else 'No')
