import re


input_list=re.findall(r"[0-9]+",input())

a = int(input_list[0])
b = int(input_list[1])

answer = a

while a >= b:
    #print("%d %d %d" %(answer,a/b,a))
    answer += (int(a / b))
    #print(answer)
    a = int(a / b) + int(a % b)

print(int(answer))
