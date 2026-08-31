n,m = map(int, input().split())
list1= []
for i in range(n):
    b = map(int, input().split())
    a = next(b)
    for j in range(a):
        list1.append(next(b))
a = set(list1)
x = 0
for i in range(1,m+1):
    if i not in a:
        x = 1
        break
print(['YES','NO'][x])
