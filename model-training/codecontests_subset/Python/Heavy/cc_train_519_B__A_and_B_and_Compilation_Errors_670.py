from collections import Counter

n=int(input())
first_error_group=input().split()
second_error_group=input().split()
third_error_group=input().split()


'''
print(first_error_group)
print(second_error_group)
print(third_error_group)
'''

#converti into lists of integers
for i in range(0,len(first_error_group)):
    first_error_group[i]=int(first_error_group[i])
for i in range(0,len(second_error_group)):
    second_error_group[i]=int(second_error_group[i])
for i in range(0,len(third_error_group)):
    third_error_group[i]=int(third_error_group[i])



#print(first_error_group)
#print(second_error_group)
#print(third_error_group)


counter_one=Counter(first_error_group)
counter_two=Counter(second_error_group)
counter_three=Counter(third_error_group)


#print(counter_one)
#print(counter_two)
#print(counter_three)

first_number=counter_one-counter_two
second_number=counter_two-counter_three


#print(first_number)
#print(second_number)

for i in first_number.keys():
    print(i)

for i in second_number.keys():
    print(i)

