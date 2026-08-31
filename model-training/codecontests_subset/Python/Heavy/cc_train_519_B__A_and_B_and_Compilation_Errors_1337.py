numErrors = int(input())
errors = [int(i) for i in input().split()]
errors1debug = [int(i) for i in input().split()]
errors2debug = [int(i) for i in input().split()]

errors.sort()
errors1debug.sort()
errors2debug.sort()


foundit = False
for i in range(numErrors-1):
    if errors[i] != errors1debug[i]:
        foundit = True
        print(errors[i])
        break
if foundit == False:
    print(errors[-1])


foundit = False
for i in range(numErrors-2):
    if errors1debug[i] != errors2debug[i]:
        foundit = True
        print(errors1debug[i])
        break
if foundit == False:
    print(errors1debug[-1])
 	 					      				 		 	 	 		  	