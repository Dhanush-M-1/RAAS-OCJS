errors = int(input())
initCompileError = list(map(int,input().split()))
initCompileError.sort()
secCompileError = list(map(int,input().split()))
secCompileError.sort()
secCompileError.append(-1)
three = list(map(int,input().split()))
three.sort()
three.append(-1)
for i in range(0,len(initCompileError)):
    if initCompileError[i] != secCompileError[i]:
        print(initCompileError[i])
        break
del secCompileError[-1]
for i in range(0,len(secCompileError)):
    if secCompileError[i] != three[i]:
        print(secCompileError[i])
        break
