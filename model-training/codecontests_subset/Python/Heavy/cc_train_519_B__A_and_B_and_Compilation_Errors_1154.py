number_compilation_errors = input()

initial_compilation_errors = [c for c in input().split(' ')]
second_compilation_errors = [c for c in input().split(' ')]
third_compilation_errors = [c for c in input().split(' ')]

initial_dict = {}
for i in initial_compilation_errors:
    if initial_dict.get(i):
        initial_dict[i] += 1
    else:
        initial_dict[i] = 1

second_dict = {}
for i in second_compilation_errors:
    if second_dict.get(i):
        second_dict[i] += 1
    else:
        second_dict[i] = 1

third_dict = {}
for i in third_compilation_errors:
    if third_dict.get(i):
        third_dict[i] += 1
    else:
        third_dict[i] = 1

for i in initial_compilation_errors:
    if not second_dict.get(i) or second_dict[i]  != initial_dict[i]:
        print(i)
        break

for i in second_compilation_errors:
    if not third_dict.get(i) or third_dict[i] != second_dict[i]:
        print(i)
        break
	   	 		 		  			  		  	 		   		