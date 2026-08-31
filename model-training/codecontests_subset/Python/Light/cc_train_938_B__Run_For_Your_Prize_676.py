n=int(input())
prizes = list(map(int, input().split()))
a1 = 1
a2 = 1000000
answer=0
for i in prizes:
    answer=max(min(abs(i-a1),abs(i-a2)), answer)
print(answer)