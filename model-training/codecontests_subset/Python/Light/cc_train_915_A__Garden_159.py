a, b = [int(i) for i in input().split()]
l = [int(i) for i in input().split()]
s = sorted(l)
for i in range(len(s)-1, -1, -1):
    if(b % s[i] == 0):
        print(b // s[i])
        break