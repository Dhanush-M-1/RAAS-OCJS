from operator import add
for t in range(int(input())):
    n,m = [int(j) for j in input().split()]
    s = input()
    tries = [int(j)-1 for j in input().split()]
    x = [0]*26
    ls = []
    for i in range(n):
        
        x_ = [q for q in x]
        x_[ord(s[i])-97] += 1
        ls.append(x_)
        x = [q for q in x_]
    tries.sort()
    x = [0]*26
    for i in range(m):
        # tem=list(map(add, ls[tries[i]], ls[-1]))
        x = list(map(add, ls[tries[i]], x))
        # print(x)
    x = list(map(add, x, ls[-1]))
    print(" ".join([str(j) for j in x]))

