q = int(input())
for i in range(q):
    l = list(map(int,input().split()))
    if l[2] < l[0]:
        print(l[2])
    elif l[2] > l[1]:
        print(l[2])
    else :
        print(l[2]*(l[1]//l[2] +1))
