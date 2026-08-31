def merge(a, b):
 res = []
 ai = 0
 bi = 0
 while ai < len(a) and bi < len(b):
  if a[ai] < b[bi]:
   res.append(a[ai])
   ai += 1
  else:
   res.append(b[bi])
   bi += 1

 while ai < len(a):
  res.append(a[ai])
  ai += 1

 while bi < len(b):
  res.append(b[bi])
  bi += 1

 return res


def merge_sort(data):
 if len(data) == 1:
  return data
 
 middle = len(data) // 2
 return merge(merge_sort(data[:middle]), merge_sort(data[middle:]))


data = input()
data = data.split("+")
print("+".join(merge_sort(data)))