# -*-coding:utf-8-*-

if __name__ == "__main__":
    n = int(input())
    is_ok = True
    order = [False, True, True, False]
    while n:
        win = int(input())
        if is_ok:
            if not order[win]:
                is_ok = False
            else:
                for i in range(1, 4):
                    if order[i]:
                        if i != win:
                            order[i] = False
                    else:
                        order[i] = True
        n -= 1
    print('YES' if is_ok else 'NO')
	 	 	  	    	  	 		   	 		  		