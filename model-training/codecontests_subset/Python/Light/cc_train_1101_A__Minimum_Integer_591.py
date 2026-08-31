q = int(input())
for i in range(q):
    a=input().split()
    if(int(a[2])>int(a[1]) or int(a[2])<int(a[0])):
        print(a[2])
    else:
        s=int(a[1])//int(a[2])
        print((s+1)*int(a[2]))
