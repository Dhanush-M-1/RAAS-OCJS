def minus(l1,l2):
    l1_s=sorted(l1)
    l2_s=sorted(l2)
    for i in range(len(l2)):
        if l1_s[i]!=l2_s[i]:
            return l1_s[i]
    return l1_s[-1]
n_e=int(input())
l1,l2,l3=list(map(int,input().split())),list(map(int,input().split())),list(map(int,input().split()))
print(minus(l1,l2))
print(minus(l2,l3))
