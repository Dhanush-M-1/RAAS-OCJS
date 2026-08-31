from collections import Counter
v=input()
a=(list(map(int,input().split())))
b=(list(map(int,input().split())))
c=(list(map(int,input().split())))
x=list((Counter(a)-Counter(b)).elements())
y=list((Counter(b)-Counter(c)).elements())
print(x[0])
print(y[0])