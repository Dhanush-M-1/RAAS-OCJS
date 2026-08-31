t = int(input())

for t1 in range(t):
    n = int(input())
    resposta = "YES"
    number_plays, number_clears = [int(c) for c in input().split()]
    
    if (number_clears > number_plays):
        resposta = "NO"

    for n1 in range(n-1):
        new_number_plays, new_number_clears = [int(c) for c in input().split()]
        if (new_number_plays < number_plays):
            resposta = "NO"
        elif (new_number_clears < number_clears):
            resposta = "NO"
        
        diff_number_plays = new_number_plays - number_plays
        diff_number_clears = new_number_clears - number_clears

        if (diff_number_clears > diff_number_plays):
            resposta = "NO"
        
        number_plays = new_number_plays
        number_clears = new_number_clears
    
    print(resposta)

 				  						 	   	   		 			 	