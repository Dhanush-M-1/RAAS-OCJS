n = int(input())
s = input()
e = min(s.count("8"), len(s)//11)
nums = (len(s)-e)//10
print(min(e,nums))
