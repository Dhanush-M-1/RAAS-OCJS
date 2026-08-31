#519B
n = int(input())
a = list(map(int,input().split()))
b = list(map(int,input().split()))
c = list(map(int,input().split()))
a.sort()
b.sort()
c.sort()
def res(x,y):
    flag = 0
    for i in range(len(y)):
        if not(x[i] == y[i]):
            d = x[i]
            flag = 1
            break
    if flag == 0:
        d = x[-1]
    return d
print(res(a,b))
print(res(b,c))