
[n, m] = list(map(int, input().split(' ')))
arrA = list(map(int, input().split(' ')))
arrB = list(map(int, input().split(' ')))

def diff_mod(a, b, m):
    result = 0
    if a <= b:
        result = b - a
    else:
        result = b - a + m
    return result

def arr_sum_mod(arr, n, m):
    new_arr = []
    for a in arr:
        new_arr.append((a + n) % m)
    return new_arr

def validate_permutation(arrA, arrB, diff, m):
    new_arr = arr_sum_mod(arrA, diff, m)
    return sorted(new_arr) == sorted(arrB)

smaller_x = 10**9
for i in range(n):
    diff = diff_mod(arrA[0], arrB[i], m)
    if diff < smaller_x and validate_permutation(arrA, arrB, diff, m):
        smaller_x = diff

        
print(smaller_x)

				  		  		  	  	  	 		 					