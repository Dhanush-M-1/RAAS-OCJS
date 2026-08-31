t = int(input())

for i in range (0, t):
    n = int(input())
    ans = "YES"
    p, c = list( map( int, input().split(' ') ) )

    if(c < 0 or p < c):
        ans = "NO"

    for j in range(1, n):
        p_, c_ = list( map( int, input().split(' ') ) )

        p_diff = (p_ - p)
        c_diff = (c_ - c)

        # print("entrei aqui")
        # print((c_ - c))
        # print((p_ - p ) )

        if( c_diff < 0 or p_diff < 0 or p_diff < c_diff ):
            ans = "NO"
        p = p_
        c = c_
    print(ans)



# t = int(input())

# for i in range (0, t):
#     n = int(input())
#     ans = "YES"
#     p, c = list( map( int, input().split(' ') ) )

#     for j in range(1, n):
#         p_, c_ = list( map( int, input().split(' ') ) )

#         p_diff = (p_ - p)
#         c_diff = (c_ - c)

#         # print((c_ - c))
#         # print((p_ - p ) )

#         if( c_diff >= 0 or p_diff - c_diff >= 0 ):
#             p = p_
#             c = c_
#         else:
#             ans="NO"
        
#     print(ans)
 	 	  		 	    	     	  		 	 			