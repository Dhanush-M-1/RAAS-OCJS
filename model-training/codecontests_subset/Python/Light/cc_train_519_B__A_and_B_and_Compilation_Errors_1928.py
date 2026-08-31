from collections import Counter
n=int(input())
a=(list(map(int,input().split())))
b=(list(map(int,input().split())))
c=(list(map(int,input().split())))
print((Counter(a)-Counter(b)).most_common()[0][0])
print((Counter(b)-Counter(c)).most_common()[0][0])