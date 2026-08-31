from collections import Counter
n = int(input())
l1 = list(map(int,input().split()))
l2 = list(map(int,input().split()))
l3 = list(map(int,input().split()))
d1,d2 = list((Counter(l1)-Counter(l2)).elements()),list((Counter(l2)-Counter(l3)).elements())
print(d1[0])
print(d2[0])