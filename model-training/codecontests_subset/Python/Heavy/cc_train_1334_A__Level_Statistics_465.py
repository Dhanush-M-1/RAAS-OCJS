cases = int(input())

for case in range(cases):
    number_of_moments = int(input())
    last_number_of_plays, last_number_of_clear = -1, -1
    flag = False
    for moment in range(number_of_moments):
        number_of_plays, number_of_clears = [int(x) for x in input().split(' ')]
        if last_number_of_plays > number_of_plays or last_number_of_clear > number_of_clears or number_of_clears - last_number_of_clear > number_of_plays - last_number_of_plays:
            flag = True
        last_number_of_plays, last_number_of_clear = number_of_plays, number_of_clears
    if not flag:
        print("YES")
    else:
        print("NO")


 	 	  			  			     	  						  	