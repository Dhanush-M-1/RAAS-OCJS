num_cases = int(input())

for case in range(num_cases):
    ans = [0] * 26
    init_ascii = 97

    line = input().split()
    n = int(line[0])
    m = int(line[1])
    s = input()
    tries = input().split()
    for i in range(len(tries)):
        tries[i] = int(tries[i])
    
    tries.sort()
    tries.reverse()

    acc_list = [1] * n
    acc_list_index = n - 2
    for i in range(m):
        for j in range(acc_list_index, tries[i] - 2, -1):
            acc_list[j] = acc_list[acc_list_index]
        acc_list_index = tries[i] - 1
        acc_list[acc_list_index] += 1

    for i in range(acc_list_index):
        acc_list[i] = acc_list[acc_list_index]
    
    for i in range(len(acc_list)):
        ans[ord(s[i]) - 97] += acc_list[i]
    
    for result in ans:
        print(result, end = ' ')
    print()
    

 	 				 				 		  	 	     				 	