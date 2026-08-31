

initialNoErr = input()
err1_tracker = {}
err2_tracker = {}
err3_tracker = {}

errs1 = input().split(' ')
for i in errs1:
    if i:
        err1_tracker[(i)] = 1 + err1_tracker.get((i), 0)

errs2 = input().split(' ')
for i in errs2:
    if i:
        err2_tracker[(i)] = 1 + err2_tracker.get((i), 0)
    
    
for key in err1_tracker:
    diff = err1_tracker[key] - err2_tracker.get(key,0) 
    while diff > 0:
        print(key)
        diff -=1    
errs3 = input().split(' ')
for i in errs3:
    if i:
        err3_tracker[(i)] = 1 + err3_tracker.get((i), 0)

for key in err2_tracker:
    diff = err2_tracker[key] - err3_tracker.get(key,0) 
    while diff > 0:
        print(key)
        diff -=1