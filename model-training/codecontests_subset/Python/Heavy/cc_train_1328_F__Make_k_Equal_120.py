# import numpy as np

# def get_num_operations(m, x):
#     if x < m: return big_number
#     if x == m: return 0
#     return 1 + get_num_operations(m, int(x / 2))


# big_number = 10000000

# n, k=map(int, input().split())
# elements_array = np.array(map(int, input().split()))
# print(1)

R=lambda:map(int,input().split())
n,k=R()
d={}
for x in R():
 i=0
 while x:l=d.setdefault(x,[]);l+=i,;x>>=1;i+=1
print(min(sum(sorted(d[x])[:k])for x in d if len(d[x])>=k))


# elements_array = np.zeros(n)
# sum_elements = 0
# i = 0
# for x in input().split():
#     element = int(x)
#     sum_elements += element
#     elements_array[i] = element
#     i += 1

# max_element = int(max(elements_array))
# best_result = big_number
# for m in range(0, max_element + 1):
#     cur_results_array = np.full(n, big_number)
#     i = 0
#     for element in elements_array:
#         cur_results_array[i] = get_num_operations(m, element)
#         i += 1
#     cur_operations = sum(np.sort(cur_results_array)[:k])
#     best_result = min(best_result, cur_operations)

# print(best_result)