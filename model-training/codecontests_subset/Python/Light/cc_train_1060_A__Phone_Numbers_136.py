#22
#0011223344556677889988
n = int(input())
t = input()
c = t.count('8')
for x in range(c,-1,-1):
    if (x + 10 * x) <= n:
        print (x)
        break