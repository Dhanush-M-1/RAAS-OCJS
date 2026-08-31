# Homework 4: Problem B -- Design a computer program operating on Python code that #outputs the least number of substrings into which 
#the inputs string must be riven, such that all the substrings are good strings, as well as #such good substrings. 
#All strings are binarily composed of 1s and 0s while, specifically, good strings are binary #strings that carry a different number of 
#ones than zeros whereas bad strings are the complementary set of binary strings.

length = int(input())

string_of_binary_digits = input()

sum = 0

for i in range(length):
  sum+=int(string_of_binary_digits[i])

final_sum = sum

if length%2==1:
  print(1)
  print(string_of_binary_digits)
elif length%2==0 and (length/2) != final_sum:
  print(1)
  print(string_of_binary_digits)
elif length%2==0 and length/2 == final_sum:
  print(2)
  print(string_of_binary_digits[0:length-1]+' '+string_of_binary_digits[length-1:length])
 							   				    									  	