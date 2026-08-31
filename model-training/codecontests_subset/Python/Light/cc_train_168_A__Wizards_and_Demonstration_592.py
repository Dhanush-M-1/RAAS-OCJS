import math
number_of_testcases = 1 #int(input())
for _ in range(number_of_testcases):
    num_citizen, num_wizard, percentage_demonstration = map(int,input().split())
    num_clones_needed = int(math.ceil((num_citizen * percentage_demonstration)/100.0))
    #print(num_clones_needed)
    if num_wizard >= num_clones_needed:
        print(0)
    else:
        print(num_clones_needed - num_wizard)
