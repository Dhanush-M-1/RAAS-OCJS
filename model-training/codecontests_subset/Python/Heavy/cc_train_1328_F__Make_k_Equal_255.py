def count(a, b):
    k = 0
    while(a > b):
        a = a//2
        k+=1
    if a==b:
        return k
    else:
        return None

n, k = input().split()
n = int(n)
k = int(k)
s = list(input().split(" "))
for i in range(n):
    s[i] = int(s[i])
s.sort()
number_of_operations = []
for i in range(1, max(s) + 1):
    sum = 0
    quantity = 0
    for number in s:
        try:
            sum += count(number, i)
            quantity += 1
        except TypeError:
            continue
        if quantity == k:
            number_of_operations.append(sum)
            break
print(min(number_of_operations))
   


"""
f = 0
while(f ==0):
    trend = collections.Counter(s).most_common()
    count = s.count(trend)
    if count == k:
        f = 1
        break

    for i in range(s.index(trend, 0, n)):
        print(i)
        #s[i]/=2
        res+=1


"""
