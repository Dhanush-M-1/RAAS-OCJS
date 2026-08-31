n , k = input().split()
n , k = int(n) , int(k)
both = []
ali = []
bob = []
while n > 0:
    t , a , b = input().split()
    t , a , b = int(t) , int(a) , int(b)
    if a == 1 and b == 1:
        both.append(t)
    elif a == 1:
        ali.append(t)
    elif b == 1:
        bob.append(t)
    n -= 1
ans = 0
both.sort(reverse = True)
ali.sort(reverse = True)
bob.sort(reverse = True)
if len(both) + min(len(ali) , len(bob)) < k:
    print(-1)
else:
    while k > 0:
        if len(both) == 0 or (len(ali) * len(bob) > 0 and (ali[-1] + bob[-1]) <= both[-1]):
            x = ali.pop(-1)
            y = bob.pop(-1)
            ans += (x + y)
        else:
            x = both.pop(-1)
            ans += x
        k -= 1
    print(ans)

