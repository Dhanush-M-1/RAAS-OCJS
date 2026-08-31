INF = int (2e9)
n, k = list (map (int, input ().split ()))
a = list (map (int, input ().split ()))
a.sort()
a = [(x, 0) for x in a]

ans = INF
ha = {}
tail = n - 1
p = 0

def lowerbound (x):
    l, r = 0, tail - 1
    while (l <= r) :
        mid = (l + r) >> 1
        if (a[mid][0] >= x) :
            r = mid - 1
        else :
            l = mid + 1
    return r + 1

def find (x):
    l = lowerbound (x[0])
    r = lowerbound (x[0] + 1) - 1
    while (l <= r) :
        mid = (l + r) >> 1
        if (a[mid][1] <= x[1]) :
            r = mid - 1
        else :
            l = mid + 1
    return r + 1

while (a[tail][0]):
    flg = True
    cnt = 0
    val = a[tail][0]

    if (a[tail - k + 1][0] == val) :
        for j in range(k) :
            cnt += a[tail - j][1]
        ans = min (ans, cnt)

    rem = k
    while (a[tail][0] == val) :
        if (rem > 0) :
            tup = (a[tail][0] // 2, a[tail][1] + 1)
            a.pop ()
            a.insert(find (tup), tup)
            rem -= 1
            # print (a)
        else :
            a.pop ()
            tail -= 1

print (ans)
	    		  				 	  				 	 			  	