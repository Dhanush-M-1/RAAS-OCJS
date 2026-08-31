l=list(map(int,input().split()))
l.sort()
print('Yes' if l[0]+l[1]==l[2] else 'No')

