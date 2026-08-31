x =[int(i) for i in list(input().split(" "))]
def t(x, z, k):
    l=x+(k//z)
    k = l + k%z
    if k>=z:
        l+=t(0, z,k)
    return l
l = t(x[0], x[1], 0)
print(l)
