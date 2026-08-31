n=int(input())
a=sorted(list(map(int,input().split())))
# print(a)
for i in range(2):
    # print("AAAAA",a)
    b=sorted(list(map(int,input().split())))
    # print(b)
    for z in range(len(b)):
        # print(a[z],b[z])
        if a[z]!=b[z]:
            print(a[z])
            break
    else:

        print(a[-1])
    a=b