def solve(array):
    odd_array = []
    even_array = []

    for elem in array:
        if elem % 2 == 0:
            even_array.append(elem)
        else:
            odd_array.append(elem)
  
    even_len = len(even_array)
    odd_len = len(odd_array)

    if abs(even_len - odd_len) <= 1:
        return 0

    odd_array = sorted(odd_array)
    even_array = sorted(even_array)

    if even_len > odd_len:
        return sum(even_array[:even_len-odd_len-1])
    
    if odd_len > even_len:
        return sum(odd_array[:odd_len-even_len-1])
     


if __name__ == '__main__':
    arr_len = int(input())
    array = list(map(int, input().split())) 
    
    print (solve(array))

