n = int(input())
for i in range(n):
    l,r,d = [int(s) for s in input().split()]
    min_no = d
    if(min_no < l or min_no > r):
        print(min_no)
    else:
        t = r//d + 1
        print(d*t)