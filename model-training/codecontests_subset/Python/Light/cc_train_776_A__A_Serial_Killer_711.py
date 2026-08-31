will = input().split()
n = int(input())
for i in range(n):
    print(will[-2], will[-1])
    a, b = input().split()
    will.remove(a)
    will.append(b)
print(will[-2], will[-1])
