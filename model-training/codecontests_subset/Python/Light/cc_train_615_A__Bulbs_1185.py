n, m = input().split() # n number of buttons and m number of bulbs
n, m = [int(n), int(m)]
on = [] # all bulbs that can be turned on
for _ in range(n):
    i, *a =map(int,input().split(' '))
    on.extend(a)
checker = {i for i in range(1,m+1)}
if checker == set(on):
    print("YES")
else:
    print("NO")