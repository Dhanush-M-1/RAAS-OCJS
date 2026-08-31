import math
cases = int(input())
for case in range(cases):
    n = int(input())
    l = [int(i) for i in input().split()]
    borders = []
    max_natural_abs_diff = 0
    for i in range(len(l)):
        if i < len(l)-1:
            if l[i] != -1 and l[i+1] != -1:
                max_natural_abs_diff = max(max_natural_abs_diff, abs(l[i]-l[i+1]))
        if l[i] == -1:
            if i > 0 and l[i-1] != -1:
                borders.append(l[i-1])
            if i < n-1 and l[i+1] != -1:
                borders.append(l[i+1])

    if len(borders) == 0:
        print(str(max_natural_abs_diff)+" 42")
    else:
        k = math.floor(max(borders)/2 + min(borders)/2)
        m = max( max_natural_abs_diff, max(borders)-k)
        print(str(m)+" "+str(k))

 		      	 	 	 		     	  	   	