n = int(input())
li = list(map(int,input().split()))
me = max(list(filter(lambda x : x <= (10**6) // 2,li))+[1]) - 1
fr = (10**6) - min(list(filter(lambda x : x > (10**6)//2,li))+[10**6])
print(max(me,fr))