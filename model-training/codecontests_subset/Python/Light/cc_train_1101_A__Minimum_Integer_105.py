num = int(input())

queries = []
for i in range(0, num):
    queries.append(list(map(int, input().split(' '))))

for i in range(0, num):
    d = queries[i][2]
    l = queries[i][0]
    r = queries[i][1]
    n = d
    while(True): 
        if n % d == 0:
            if n < l or n > r:
                print(n)
                break
            elif n >= l and n <= r: 
                n += r - n
        n += d - (n % d)
