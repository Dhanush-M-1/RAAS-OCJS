lst = input().split(" ")
n = int(input())
last = lst[::]
for i in range(n):
    lst.append(None)
    lst.append(None)
    f = input().split(" ")
    if f[0] == last[0]:
        lst[-2] = f[1]
        lst[-1] = lst[-3]
    else:
        lst[-1] = f[1]
        lst[-2] = lst[-4]
    last = lst[-2::]
for k in range(0,len(lst),2):
    print(lst[k] + " " + lst[k+1])
