tc=int(input())
errors=[input().split() for i in range(3)]
step1=0
step2=0
step3=0

for i in range(0,tc,1):
    step1+=int(errors[0][i])


for i in range(0,tc-1,1):
    step2+=int(errors[1][i])

for i in range(0,tc-2,1):
    step3+=int(errors[2][i])

result1=step1-step2
result2=step2-step3
print(result1)
print(result2)
