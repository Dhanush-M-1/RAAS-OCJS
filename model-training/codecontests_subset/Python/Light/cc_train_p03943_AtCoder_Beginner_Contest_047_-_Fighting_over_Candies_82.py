s=sorted(list(map(int,input().split())))
print('NYoe s'[s[-1]==sum(s[:2])::2])
