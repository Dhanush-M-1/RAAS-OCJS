t = int(input())

for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))

    if all(x == -1 for x in a):
        print(0, 42)
        continue

    pairs = zip(a, a[1:])
    pairs_filtered = filter(lambda t: (t[0] == -1 or t[1] == -1) and t[0] != t[1], pairs)
    nums = list(map(lambda t: t[0] if t[0] != -1 else t[1], pairs_filtered))

    res_n = (max(nums) + min(nums)) // 2

    a = list(map(lambda x: x if x != -1 else res_n, a))
    diff = map(lambda x: abs(x[0] - x[1]), zip(a, a[1:]))
    print(max(diff), res_n)
	    		    			    		 	 	 	    	