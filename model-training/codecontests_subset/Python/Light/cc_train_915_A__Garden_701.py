#!
c = input()
n, k = [int(x) for x in c.strip().split(" ")]
a = [int(i) for i in input().strip().split(" ")]
a.sort(reverse=True)
for i in a:
    if k % i == 0:
        print(int(k/i))
        break