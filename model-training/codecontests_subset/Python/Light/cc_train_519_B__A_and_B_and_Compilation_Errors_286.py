n = int(input())
a = input()
b = input()
c = input()
an = a.split()
bn = b.split()
cn = c.split()
an = [int(k) for k in an]
bn = [int(k) for k in bn]
cn = [int(k) for k in cn]
sum(int(x) for x in an)
sum(int(x) for x in bn)
sum(int(x) for x in cn)
print(sum(int(x) for x in an)-sum(int(x) for x in bn))
print(sum(int(x) for x in bn)-sum(int(x) for x in cn))