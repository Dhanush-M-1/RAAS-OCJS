


if __name__ == '__main__':
    x = int(input())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    c = list(map(int, input().split()))
    a.sort()
    b.sort()
    c.sort()
    flag = False
    for i in range(len(a)):
        if(i<len(b)):
            if(a[i]!=b[i]):
                print(a[i])
                flag = True
                break
    if(flag==False): print(a[len(a)-1])
    flag = False
    for i in range(len(b)):
        if (i < len(c)):
            if (b[i] != c[i]):
                print(b[i])
                flag = True
                break
    if (flag == False): print(b[len(b) - 1])



		   				  	     		 	 	 	 		