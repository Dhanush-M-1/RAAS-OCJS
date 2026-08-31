from collections import Counter 
n=int(input())
l1=list(map(int,input().split()))
l2=list(map(int,input().split()))
l3=list(map(int,input().split()))
l=list((Counter(l1)-Counter(l2)).elements())
l4=list((Counter(l2)-Counter(l3)).elements())
print(*l)
print(*l4)