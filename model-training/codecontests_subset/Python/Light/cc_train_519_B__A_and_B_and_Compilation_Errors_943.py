from collections import Counter
n=int(input())
l1=list(map(int,input().split()))
l2=list(map(int,input().split()))
l3=list(map(int,input().split()))
c1 = Counter(l1)
c2 = Counter(l2)
c3 = Counter(l3)
x=c1-c2
y=c2-c3
print(*list(x.elements()))
print(*list(y.elements()))