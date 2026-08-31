t = int(input())
while t > 0:
    n, m = [int(ele) for ele in input().split()]
    s = input()
    p = [int(ele) for ele in input().split()]
    count = []
    for i in range(26):
        count.append(0)
    lst = []
    for i in range(n):
        lst.append(0)
    for i in range(m):
        lst[p[i]-1] += 1

    for i in range(n-1, 0, -1):
        lst[i-1] += lst[i]

    for i in range(n):
        count[(ord(s[i])-97)] += lst[i] + 1

    for ele in count:
        print(ele, end=" ")
    t -= 1
