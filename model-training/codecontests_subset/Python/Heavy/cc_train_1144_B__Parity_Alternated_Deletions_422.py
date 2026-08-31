def solve(a):
    a.sort()
    odd = []
    even = []
    for i in a:
        if i%2==0:
            even.append(i)
        else:
            odd.append(i)
    if abs(len(even) - len(odd)) <=1 :
        return 0
    else:
        if len(even) > len(odd):
            l = len(even) - len(odd) - 1
            return sum(even[:l])
        else:
            l = len(odd) - len(even) - 1
            return sum(odd[:l])


n = int(input())
x = input().split()
a = []
for i in x:
    a.append(int(i))
print(solve(a))
