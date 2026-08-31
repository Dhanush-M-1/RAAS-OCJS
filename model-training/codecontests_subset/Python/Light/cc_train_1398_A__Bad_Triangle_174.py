n = int(input())
for i in range(n):
    t = int(input())
    l = input()
    i_l = [int(x) for x in l.split(" ")]
    if i_l[t-1] >= (i_l[0] + i_l[1]):
         print("1 2 " + str(t))
    else:
        print("-1")