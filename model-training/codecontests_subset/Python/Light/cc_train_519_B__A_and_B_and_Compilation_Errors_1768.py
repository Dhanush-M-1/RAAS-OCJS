def main():
	n = input()
	err1 = [int(i) for i in input().split()]
	err2 = [int(i) for i in input().split()]
	err3 = [int(i) for i in input().split()]
	err1.sort()
	err2.sort()
	err3.sort()
	for el in err2:
		err1.remove(el)
	for el in err3:
		err2.remove(el)
	print(err1[0])
	print(err2[0])



if __name__ == "__main__":
	main()
  	 	 	  	 	   	 		  		 				 	