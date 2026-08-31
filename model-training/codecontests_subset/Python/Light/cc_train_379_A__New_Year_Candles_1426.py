a,b = [int(i) for i in input().split()]
q = a
while q>1:
    q = q/b
    a = a+q
print(int(a))