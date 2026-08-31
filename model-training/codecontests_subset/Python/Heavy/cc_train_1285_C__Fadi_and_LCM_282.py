def primfacs(n):
    i = 2
    primfac = []
    while i * i <= n:
        tmp = 1
        while n % i == 0:
            tmp *= i
            n = n // i
        primfac.append(tmp)
        i = i + 1
    if n > 1:
        primfac.append(n)
    primfac.sort(reverse=True)
    return primfac
   
X = int(input())
ps = primfacs(X)

products = set([1])
for p in ps:
    new_set = []
    for product in products:
        new_set.append(product*p)
    products.update(new_set)

a = 1
b = X
min_max = X
for p in products:
    new_b = X//p
    new_max = max(p, new_b)
    # print(p, new_max)
    if new_max < min_max:
        a = p
        b = new_b
        min_max = new_max

# print(products)
print(a, b)
