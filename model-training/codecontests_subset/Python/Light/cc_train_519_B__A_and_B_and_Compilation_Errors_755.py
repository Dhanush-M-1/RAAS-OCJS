from collections import Counter 
n=int(input())
l1=list(map(int,input().split()))
l2=list(map(int,input().split()))
l3=list(map(int,input().split()))
res1 = list((Counter(l1) - Counter(l2)).elements())
res2 = list((Counter(l2) - Counter(l3)).elements())
print(*res1)
print(*res2)
