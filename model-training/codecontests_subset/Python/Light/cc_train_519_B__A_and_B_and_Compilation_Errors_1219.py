n1=int(input())
ls1 = [int(n) for n in input().split()]
ls2 = [int(n) for n in input().split()]
ls3 = [int(n) for n in input().split()]
print(sum(ls1)-sum(ls2))
print(sum(ls2)-sum(ls3))