n = int(input())
a = [int(i) for i in input().split(" ")]
b = [int(i) for i in input().split(" ")]
c = [int(i) for i in input().split(" ")]

a.sort()
b.sort()
c.sort()

ultimo = True
for i, j in zip(a, b):
    if i != j:
        ultimo = False
        print(i)
        break
if ultimo:
    print(a[-1])

ultimo = True
for i, j in zip(b, c):
    if i != j:
        print(i)
        ultimo = False
        break

if ultimo:
    print(b[-1])