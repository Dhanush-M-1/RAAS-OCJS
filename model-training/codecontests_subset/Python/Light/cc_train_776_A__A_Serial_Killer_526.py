# print("Input the starting names")
a = [x for x in input().split()]
# print("Input n")
n = int(input())

print(a[0] + " " + a[1])
for i in range(n):
    # print("Input the dead person and their replacement")
    d, e = [x for x in input().split()]
    if d == a[0]:
        a[0] = e
    else:
        a[1] = e
    print(a[0] + " " + a[1])
    
