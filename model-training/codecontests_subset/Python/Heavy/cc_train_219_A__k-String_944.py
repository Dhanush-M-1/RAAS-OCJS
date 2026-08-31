def main():
    k = int(input())

    contadores = {}
    string = input()

    if k > len(string):
        print(-1, end='')
        exit()

    for letra in string:
        if letra not in contadores:
            contadores[letra] = 0
        contadores[letra] += 1
        
    for letra in contadores:
        if contadores[letra] % k != 0:
            print(-1, end='')
            exit()

    base = ''.join([letra*(contadores[letra]//k) for letra in contadores])
    output = base * k
    
    print(output, end='')

        


if __name__ == "__main__":
    main()
 	 	 					  		   		  			 		  	