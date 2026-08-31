n=int(input())
for i in range(n):
    l=[int(i) for i in input().split()]
    if (l[2]<l[0])or(l[2]>l[1]):
        print(l[2])
    else :
              print((int((l[1])//(l[2]))+1)*l[2])