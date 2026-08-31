k = int(input())
string = input()
dicts = {}
lists = []
for i in string:
          lists.append(i)
mass = set(lists)

for j in mass:
          dicts[j] = 0
          for i in lists:
                    if j == i:
                              dicts[j] += 1  

for j in mass:
          if dicts[j]%k != 0:
                    key = True
                    break
          else:
                   key = False
new_string = ''
if key == False:
          lists = []
          for i in dicts:
                    lists.append(i)
          lists.sort()
          while len(new_string) < len(string):
                    for i in lists:
                              for j in range(int(dicts[i]/k)):
                                        new_string += i
          print(new_string)
else:
          print(-1)
