p = input().split(' ')
first = p[:]
n = int(input())
l = []
i = 0
while i < n:
    h,k = input().split(' ')
    p.remove(h)
    l.append(p[0])
    l.append(k)
    p.append(k)
    i+=1
print(first[0]+" "+first[1])
i = 0
while i < n*2:
    print(l[i]+" "+l[i+1])
    i+=2
