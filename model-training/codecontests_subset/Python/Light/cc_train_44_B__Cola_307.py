n, a, b ,c = [int(x) for x in input().split()]
count=0
for i in range(c+1):
    for j in range(b+1):
        t= n - i*2 -j
        if t>=0 and a*0.5 >= t:
            count+=1
print(count)
