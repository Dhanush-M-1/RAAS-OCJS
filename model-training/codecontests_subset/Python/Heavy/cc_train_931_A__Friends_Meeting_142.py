import math
# y, x = list(map(int, input().split("\n")))

x = int(input().strip())
y = int(input().strip())

def test_1(y, x):
    a = y - x + 1
    if x == 0:
        return "No"
    if x ==1 and y !=0:
        return "No"
    if a < 0:
        return "No"
    else:
        b = a/2 + 1
        if round(b/round(b), 10)==1.0:
            return 'Yes'
        else:
            return 'No'

def test_2(y, x):
    n = abs(x - y)
    # print(x, y, n)

    if n % 2 == 1:
        n = n//2 + 1
        a1 = n*(n-1)/2
        a2 = n*(n+1)/2
        a = a1+a2
    else:
        n = n // 2
        a = n * (n + 1)

    return int(a)

aa = test_2(y, x)
print(aa)

   	   	  	 	  			 		  						