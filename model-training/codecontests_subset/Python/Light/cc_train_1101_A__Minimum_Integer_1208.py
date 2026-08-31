t= int(input())
for x in range(t):
        a=[int(x) for x in input().split()]
        s=a[2]
        if s<a[0]:
                print(s)
        elif s>a[1]:
                print(s)
        else:
                print(s*((int(a[1]/s))+1))