


def f(n,l):
        for i in range(l-2):
            for ii in range(1,l-1):
                for iii in range(2,l):
                    if n[iii]>=n[ii]+n[i]:
                        return (i+1,ii+1,iii+1)
                return [-1]

for _ in range(int(input())):
    l = int(input())
    n = [int(x) for x in input().split()]
    print(*f(n,l))

    