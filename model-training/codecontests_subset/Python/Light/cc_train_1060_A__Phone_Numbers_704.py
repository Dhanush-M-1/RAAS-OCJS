n = int(input())
arr = [x for x in input()]
count = arr.count('8')
answer = 0
for i in range(1, count+1):
    answer = max(answer, min(i, (n-i)//10))
print(answer)
