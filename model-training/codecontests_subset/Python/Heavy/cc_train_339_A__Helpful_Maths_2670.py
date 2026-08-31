string = str(input())

data = string.split("+")
a1 = 0
a2 = 0
a3 = 0

for temp in data:
       if int(temp) == 1:
              a1 = a1 + 1
              pass
       if int(temp) == 2 :
              a2 = a2 + 1
              pass
       if int(temp) == 3:
              a3 = a3 + 1
              pass

new_string = ""
new_string1 = ""
new_string2 = ""
final_string = ""
for number in range(a1):
       new_string = new_string + "1+"
for number in range(a2):
       new_string1 = new_string1 + "2+"
for number in range(a3):
       new_string2 = new_string2 + "3+"

final_string = final_string + new_string+new_string1+new_string2
print(final_string[0:len(final_string) - 1])