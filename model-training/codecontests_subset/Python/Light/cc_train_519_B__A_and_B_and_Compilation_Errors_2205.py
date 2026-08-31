n = int(input())
ls = sum([int(a) for a in input().split(" ")])
p = sum([int(a) for a in input().split(" ")])
a = ls - p
ls = p
b = ls - sum([int(a) for a in input().split(" ")])
print(str(a)+"\n"+str(b))