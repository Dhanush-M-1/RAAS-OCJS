L=list(map(int,input().split()))
print('YNeos'[2*max(L)!=sum(L)::2])