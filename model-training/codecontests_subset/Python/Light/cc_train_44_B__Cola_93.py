n, a, b, c = map(int, input().split())
count = 0
for i in range(c+1):
    for j in range(b+1):
        temp = n - i*2 -j
        if temp>=0 and a*0.5 >= temp:
            count+=1
print(count)