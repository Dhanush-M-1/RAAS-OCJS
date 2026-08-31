def main():
    t = int(input())
    for _ in range(t):
        a, b, c = [int(i) for i in input().split(' ')]
        res = 0
        for i in range(b, 0, -1):
            if(b > 0):
                if c > 1:
                    c -= 2
                    b -= 1
                    res += 3
                elif a != 0 and b >= 2:
                    b -= 2
                    a -= 1
                    res += 3
                else:
                    break
            else:
                break
        
        #3 10 6
        print(res)


if __name__ == '__main__':
    main()
  	  		    	 	 	 			 			      	