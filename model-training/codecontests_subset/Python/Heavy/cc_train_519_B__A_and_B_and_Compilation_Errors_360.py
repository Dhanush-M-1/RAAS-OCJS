initial_num_errors = int(input())

# the first compilation has all the errors
first_compilation = [int(a) for a in input().strip().split()]

# put all the errors the first compilation in a dictionary
first_errors = dict()
for i in first_compilation:
    first_errors[i] = first_errors.get(i, 0) + 1

# the second compilation has 1 less error the first one
second_compilation = [int(a) for a in input().strip().split()]

# make a list for the removed errors
removed_second = []
# make a dictionary for the second compilation
second_errors = dict()
for i in second_compilation:
    second_errors[i] = second_errors.get(i, 0) + 1


# the third compilation has one less error than the second one
third_compilation = [int(a) for a in input().strip().split()]
removed_third= []
third_errors = dict()

for i in third_compilation:
    third_errors[i] = third_errors.get(i, 0) + 1


# find the errors removed in the second compilation
for k, v in first_errors.items():
    if k in second_errors:
        if second_errors[k] != v:
            removed_second.append(k)
            break
    else:
        removed_second.append(k)
        break

# find the errors removed in the third compilation
for k, v in second_errors.items():
    if k in third_errors:
        if third_errors[k] != v:
            removed_third.append(k)
            break
    else:
        removed_third.append(k)
        break

# print the results
print(removed_second[0])
print(removed_third[0])
