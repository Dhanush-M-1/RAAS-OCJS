pi = 3.141592653589793238462643383279502884197169399375105820974
n, px, py = [int(i) for i in input().split(' ')]
p = [[int(i) for i in input().split(' ')] for i in range(n)]
p.append(p[0])
b = (p[0][0] - px)**2 + (p[0][1] - py)**2
Min, Max = b, b
for i in range(1,len(p)):
    a = (p[i][0] - p[i-1][0])**2 + (p[i][1] - p[i-1][1])**2
    c = b
    b = (p[i][0] - px)**2 + (p[i][1] - py)**2
    an = max(b - a - c, c - a - b)
    if an >= 0:
        if b < Min:
            Min = b
    else:
        tmp = (p[i][0] - px) * (p[i-1][1] - py) - (p[i-1][0] - px) * (p[i][1] - py)
        tmp = tmp**2 / a
        if tmp < Min:
            Min = tmp
    if b > Max:
        Max = b
print('%.18f'%((Max-Min)*pi))
 	  	  	  			 		  	 	 	    		