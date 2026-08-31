n = input()
err1 = input().split(' ')
err1 = [int(err) for err in err1]
err1.sort()

err2 = input().split(' ')
err2 = [int(err) for err in err2]
err2.sort()

err3 = input().split(' ')
err3 = [int(err) for err in err3]
err3.sort()

last = True
for i in range(len(err2)):
    if(err1[i]!=err2[i]):
        print(err1[i])        
        last = False
        break
if last:
    print(err1[i+1])

last = True
for i in range(len(err3)):
    if(err2[i]!=err3[i]):        
        print(err2[i])        
        last = False
        break
if last:
    print(err2[i+1])
