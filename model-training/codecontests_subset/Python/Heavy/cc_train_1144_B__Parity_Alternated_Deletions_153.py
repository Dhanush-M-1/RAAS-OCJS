n = int(input())
l = [0] + list(map(int, input().split()))  
ans = sum(l)

sum_ch = 0   #ch
sum_n = 0   #n
while True:
    max_ch = 0
    max_n = 0
    for i in range(1, len(l)):
        if l[i]%2 == 0 and l[i] > l[max_ch]:
            max_ch = i
        elif l[i]%2==1 and l[i] > l[max_n]:
            max_n = i
    sum_ch += l[max_ch]
    sum_n += l[max_n]
    if l[max_ch] != 0:
        sum_ch += l[max_n]
    if l[max_n] != 0:
        sum_n += l[max_ch]
    if l[max_ch] == 0 or l[max_n] == 0:
        break
    l[max_ch] = 0
    l[max_n] = 0    
print(ans-max(sum_ch, sum_n))