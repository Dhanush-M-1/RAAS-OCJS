# Paulo Pacitti
# RA 185447

n = int(input())
first_compilation = list(map(lambda e: int(e), input().split(' ')))
second_compilation = list(map(lambda e: int(e), input().split(' ')))
third_compilation = list(map(lambda e: int(e), input().split(' ')))

first_error = sum(first_compilation) - sum(second_compilation)
second_error = sum(second_compilation) - sum(third_compilation)

print(first_error)
print(second_error)
	 	   	  				  	 				  		  		 	