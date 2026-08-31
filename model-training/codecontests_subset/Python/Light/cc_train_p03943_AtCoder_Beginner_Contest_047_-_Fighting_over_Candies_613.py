a=sorted(list(map(int,input().split())))
print('Yes' if a[-1]==sum(a)-a[-1] else 'No')