n = int(input())
error_step_1 = list(map(int, input().split(' ')))
error_step_2 = list(map(int, input().split(' ')))
error_step_3 = list(map(int, input().split(' ')))

def diff(first, second):
    first_copy = first.copy()
    second_copy = second.copy()
    first_copy.sort()
    second_copy.sort()
    return_values = None
    for i in range(len(first_copy) - 1):
        if ((first_copy[i] != second_copy[i]) and (i <= len(second_copy) - 1)):
            return_values = first_copy[i]
            break
        if return_values is None:
            return_values = first_copy[len(first_copy) - 1]
        
    return return_values

print(diff(error_step_1, error_step_2))
print(diff(error_step_2, error_step_3))