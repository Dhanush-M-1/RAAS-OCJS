n = int(input())
str = input().split()
pos1 = 1
posn = 1000000
sum = 0
j = 0
l = 0
for i in range(n) :
    if int(str[l]) - pos1 < posn - int(str[n - j - 1]) :
        k = int(str[l]) - pos1
        sum += k
        pos1 = int(str[l])
        posn -= k
        l += 1
    else :
        k = posn - int(str[n - j - 1])
        sum +=  k
        posn = int(str[n - j - 1])
        pos1 += k
        j += 1
print(sum)

