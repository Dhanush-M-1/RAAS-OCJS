a,b,c=map(int,input().split())
print('Yes' if sum([a,b,c])-max(a,b,c)*2==0 else 'No')