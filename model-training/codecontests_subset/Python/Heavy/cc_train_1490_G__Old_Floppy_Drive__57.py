#TESTING FAST IO AGAIN
import io,os,sys

input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

in_length = int(input())
final_ouput = []

def find_minimum_stop(array, element, start, end):
  mid = (start+end)//2
  
  if start == end:
    return 0
  
  if element == array[mid]:
    return mid
  
  if element <= array[mid+1] and element> array[mid]:
    return mid+1
  elif element > array[mid+1]:
    return find_minimum_stop(array, element, mid+1, end)
  elif element < array[mid]:
    return find_minimum_stop(array, element, start, mid)
  

for i in range(in_length):
  
  index_saver = dict()
  
  [n, m] = input().decode().split()
  acc_sum = 0
  sum_arr = input().decode().split()
  questions = input().decode().split()
  
  biggest_num = 0;
  
  index_saver.update([(-1,-1)])
  check_arr = [-1]
  
  for j in range(int(n)):
    acc_sum += int(sum_arr[j])
    sum_arr[j] = acc_sum
    if  acc_sum > biggest_num:
      index_saver.update([(sum_arr[j], j)])
      biggest_num = acc_sum
      check_arr.append(sum_arr[j])
   
  diff = sum_arr[-1] 
  out_arr = []
  
  
  if diff <= 0:
    for q in questions:
      if int(q) > biggest_num:
        out_arr.append('-1')
      else:
        min_index = index_saver[check_arr[find_minimum_stop(check_arr, int(q), 0, len(check_arr)-1)]]    
        out_arr.append(str(min_index))
           
  else:
    cycle_arr = check_arr[find_minimum_stop(check_arr, biggest_num-diff, 0, len(check_arr)-1):]
    cycle_arr.insert(0, -1)
    
    for q in questions:
      
      if int(q) <= biggest_num:
        cycles = 0
      else: 
        cycles = (int(q)-biggest_num)/diff
        
        if cycles.is_integer():
          cycles = (int(q)-biggest_num)//diff
        else:
          cycles = (int(q)-biggest_num)//diff + 1
      
      if cycles == 0:
        min_index = index_saver[check_arr[find_minimum_stop(check_arr, int(q), 0, len(check_arr)-1)]]    
        out_arr.append(str(min_index))
      else:
        min_index = index_saver[cycle_arr[find_minimum_stop(cycle_arr, int(q)-diff*cycles, 0, len(cycle_arr)-1)]]
        out_arr.append(str(min_index + int(n)*(cycles)))
                    
  
  final_ouput.append(' '.join(out_arr))

for out in final_ouput:
  sys.stdout.write(out + "\n")
