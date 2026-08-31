s = input().split()
n, K = int(s[0]), int(s[1])

d = input().split()
d = [int(i) for i in d]
d.sort()

c = 0
#print(d)
for i in range(n - 1):
    if d[i+1] - d[i] <= K and d[i+1] > d[i]:
        c += 1
        #print('{} eats {}'.format(d[i+1], d[i]))
        if i > 0:
            if d[i] == d[i-1]:
                j = i-1
                while d[j] == d[i]:
                    #print('{} eats {}'.format(d[i + 1], d[j]))
                    j -= 1
                    c += 1
        continue


print(n - c)