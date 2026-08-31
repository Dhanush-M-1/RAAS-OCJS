from collections import Counter
n=input()
l1=list(map(int,input().split()))
l2=list(map(int,input().split()))
l3=list(map(int,input().split()))
print(*list((Counter(l1)-Counter(l2)).keys()))
print(*list((Counter(l2)-Counter(l3)).keys()))

