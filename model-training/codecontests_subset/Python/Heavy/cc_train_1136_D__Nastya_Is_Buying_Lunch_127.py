from sys import stdin, stdout

input = stdin.readline
# print = stdout.write
listin = lambda : list(map(int, input().split()))
mapin = lambda : map(int, input().split())
n, m = mapin()
l = listin()

ha = set()

for i in range(m):

    ha.add(tuple(mapin()))



count = 0
z = l[-1]
j = n-1


if  j == 0:
    print(count)
else:
    seti = []

    while j>=0:

        if seti == []:
            seti.append(l[j])
            j-=1
        else:
            flag = 0
            for x in seti:
                if (l[j],x) not in ha:
                    flag = 1
                    break
            if flag == 0:
             j-=1
             count+=1
            else:
                seti.append(l[j])
                j-=1

    print(count)


