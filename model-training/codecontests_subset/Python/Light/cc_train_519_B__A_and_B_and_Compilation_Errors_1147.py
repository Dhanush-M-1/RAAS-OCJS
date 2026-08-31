n=int(input())
l1=[int(x) for x in input().split()]
l2=[int(x) for x in input().split()]
a=sum(l1)-sum(l2)
print(a)
l3=[int(x) for x in input().split()]
print(sum(l1)-sum(l3)-a)