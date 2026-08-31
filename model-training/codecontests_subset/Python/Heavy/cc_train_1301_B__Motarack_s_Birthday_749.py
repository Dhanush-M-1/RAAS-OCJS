v = int(input())
for l in  range(v):
    min_ = 10**9
    max_ = 0
    _ = input()
    s = [int(x) for x in input().split(" ")]
    for i, p in enumerate(s):
        if p == -1:
            if i - 1 >= 0:
                if s[i-1] != -1:
                    min_ = min([min_, s[i-1]])
                    max_ = max([max_, s[i-1]])
            if i + 1 < len(s):
                if s[i+1] != -1:
                    min_ = min([min_, s[i+1]])
                    max_ = max([max_, s[i+1]])
    k = (min_ + max_)//2
    s = [x if x != -1 else k for x in s]
    max_2 = 0
    for i, a in enumerate(s):
        if i - 1 >= 0:
            max_2 = max([max_2, abs(a - s[i-1])])
    print(max_2, k)
					 		  						    	   		    	