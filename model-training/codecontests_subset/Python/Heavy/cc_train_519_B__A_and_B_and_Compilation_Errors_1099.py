

def disapeared_errors(errors1, errors2):
    errors = []
    for i in range(len(errors1)):
        if i < len(errors2) and errors1[i] != errors2[i]:
            errors += [errors1[i]]
            break
        elif i == len(errors2):
            errors += [errors1[i]]
    return errors


def get_int():
    from sys import stdin
    return int(stdin.readline().replace('\n', ''))

def get_int_list():
    from sys import stdin
    return [int(x) for x in stdin.readline().replace('\n','').split(' ')]

n = get_int()
errors1 = get_int_list()
errors2 = get_int_list()
errors3 = get_int_list()

errors1.sort()
errors2.sort()
errors3.sort()


disapeared = disapeared_errors(errors1, errors2)
disapeared += disapeared_errors(errors2, errors3)

for d in disapeared:
    print(d)

	  	   		   			     	  	 		  	