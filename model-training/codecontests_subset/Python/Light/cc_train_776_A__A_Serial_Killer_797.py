people = input().split()

n = int(input())

print(' '.join(people))
for i in range(n):
    p1, p2 = input().split()
    people[people.index(p1)] = p2
    print(' '.join(people))


  	   		  			  	   	 				  	  	