def check_validity(list_tuples):
	curr_plays=0
	curr_clears=0
	for tup in list_tuples:
		delta_plays=tup[0]-curr_plays
		delta_clears=tup[1]-curr_clears
		if delta_plays<delta_clears:
			return False
		if delta_clears<0 or delta_plays<0:
			return False
		curr_plays+=delta_plays
		curr_clears+=delta_clears
	return True
		


def main():
	n_test_cases=int(input())
	for test_case in range(n_test_cases):
		n_moments=int(input())
		obs=[]
		for moment in range(n_moments):
			tup=input()
			plays=int(tup.split(" ")[0])
			clears=int(tup.split(" ")[1])
			obs.append((plays, clears))
		if check_validity(obs):
			print("YES")
		else:
			print("NO")

main()