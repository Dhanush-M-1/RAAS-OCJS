while True:
    try:
        n, m = list(map(int, input().split()))
        ans = n
        while n >= m:
            ans += n//m
            n = n//m + n%m
        print(ans)
    except EOFError:
        break


     		 	 	 				  		 						 	 	