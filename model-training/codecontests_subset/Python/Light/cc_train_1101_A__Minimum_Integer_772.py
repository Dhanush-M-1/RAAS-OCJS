n_consultas = int(input())
if 1 <= n_consultas <= 500:
    for i in range(n_consultas):
        l,r,d = input().split(" ")
        l,r,d = int(l), int(r), int(d)
        if 1 <= l <= r <= 10**9 and 1 <= d <= 10**9:            
            x = d
            
            if d < l:
                print (d)
            else:
                m = int(r/d)
                while True:
                    x = d*m                   
                    if x > r:
                        print (x)
                        break
                    m += 1
 	 		  						  	 	 	 			  		