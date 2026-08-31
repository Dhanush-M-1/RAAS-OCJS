from collections import OrderedDict


t = int(input())


for _ in range(t):
    letters = OrderedDict((l, 0) for l in 'abcdefghijklmnopqrstuvwxyz')
    n_s, n_err = map(int, input().split())
    s = list(input())
    errors = sorted(list(map(int, input().split())))

    for err_i, err in enumerate(errors):
        if err_i > 0:
            for l in s[errors[err_i-1]:err]:
                letters[l] += n_err - err_i
        else:
            for l in s[:err]:
                letters[l] += n_err

    for l in s:
        letters[l] += 1

    print(' '.join(str(v) for _, v in letters.items()))
  	 		 	 						  	  	 	 	 	 	 	