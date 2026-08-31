def main():
    num = int(input())
    sequence = input()
    grams_dict = dict()
    s = 0
    f = 1

    while s < (num - 1):
        aux = sequence[s:(f + 1)]
        if aux in grams_dict:
            grams_dict[aux] += 1
        else:
            grams_dict[aux] = 1
        s += 1
        f += 1

    max = 0
    gram = ""
    for key, value in grams_dict.items():
        if value > max:
            max = value
            gram = key

    print(gram)
    return

if __name__ == "__main__":
    main()
	  	  	 	 	   	    	 			 	  			