# print("Input n and k")
n, k = [int(x) for x in input().split()]

# print("Input the n numbers")
a = [int(x) for x in input().split()]

a.sort()

for i in range(len(a)-1, -1, -1):
    nxt = a[i]
    if k%nxt == 0:
        print(k//nxt)
        quit()
