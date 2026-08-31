__author__ = """

 
   ***   	           *
    *                  *
    *                  *
    *	 ****	 ****  *****    ****   *   *
    *	*   *   *      *   *    *  *   *   *   
    *	*   *   *      *   *    *  *   *   *
*   *	*   *   *      *   *    *  *   *****      
*   *	*   *   *      *   *    *  *       *  
 ***	 *** *  *      *****    *** *      * 
                                           *
********************************************  
"""
"""ya parçalayacam ya parçalayacam ya da parçalayacammm :)"""

from math import sqrt as jarbay
a, b, c = map(int, input().split())
delta = b * b - 4 * a * c
if(a == 0):
	if(b == 0):
		if(c == 0): print(-1)
		else: print(0)
	else:
		print(1)
		u = (-1 * c) / b
		print("%.5f" % u)
else:
	if(delta < 0): print(0)
	elif(delta == 0):
		print(1)
		u = -1 * b / (2 * a)
		print("%.5f" % u)
	else:
		x1 = (-1 * b + jarbay(delta) ) / (2 * a) 
		x2 = (-1 * b - jarbay(delta) ) / (2 * a)
		if(x1 > x2): x1 , x2 = x2, x1
		print(2)
		print("%.5f" % x1)
		print("%.5f" % x2)