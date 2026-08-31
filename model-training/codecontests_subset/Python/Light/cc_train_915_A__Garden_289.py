import sys
def main():
   input1 = input().split(" ")
   input2 = input()
      
   buckets = int(input1[0])
   length = int(input1[1])
   minHour = length
   for char in input2.split(" "):
      #print(char)
      if length%int(char)==0:
         if length/int(char)<minHour:
            minHour = length/int(char)
   print (int(minHour))
main()