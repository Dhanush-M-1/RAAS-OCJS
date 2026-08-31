n = int(input())
s = input()

m = s.count("8")
n

if m == 0 or n < 11:
    print(0)

else:
    lo,hi = 1,m
    while lo <= hi:
        mid = (lo+hi) // 2
        if mid * 10 <= n - mid:
            lo = mid + 1
        else:
            hi = mid - 1
    print(hi)

    
