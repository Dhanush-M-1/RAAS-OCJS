from collections import Counter


def errors(n, err, err1, err2):

    err = Counter(err)
    err1 = Counter(err1)
    err2 = Counter(err2)

    res1 = err-err1
    res2 = err1-err2

    for i in res1.elements(): 
        print(i)
    for i in res2.elements(): 
        print(i)




n = int(input())
err = list(map(int,input().split()))
err1 = list(map(int,input().split()))
err2 = list(map(int,input().split()))
errors(n, err, err1, err2)
  		 					   		 	 		 		  		   	