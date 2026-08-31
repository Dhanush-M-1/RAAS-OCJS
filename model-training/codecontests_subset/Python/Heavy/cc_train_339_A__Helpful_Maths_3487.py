def get_main_obj(data, l, r):
 return (r + l) // 2

def quick_sort(data, l, r):
 if l >= r:
  return 

 mark = get_main_obj(data, l, r)
 ll = l
 rr = r

 while ll != mark or rr != mark:
  while data[ll] <= data[mark] and ll != mark:
   ll += 1

  while data[rr] > data[mark] and rr != mark:
   rr -= 1

  if ll == rr == mark:
   break

  data[ll], data[rr] = data[rr], data[ll]
  if ll == mark:
   mark = rr
  elif rr == mark:
   mark = ll

 quick_sort(data, l, mark - 1)
 quick_sort(data, mark + 1, r)


data = input()
data = data.split("+")
quick_sort(data, 0, len(data)-1)
print("+".join(data))