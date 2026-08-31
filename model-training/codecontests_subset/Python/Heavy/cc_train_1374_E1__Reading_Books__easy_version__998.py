n, k = map(int, input().split())

both, alice, bob = [], [], []

for _ in range(n):
    t, a, b = map(int, input().split())
    if a == 1 and b == 1:
        both.append(t)
    elif a == 1 and b == 0:
        alice.append(t)
    elif a == 0 and b == 1:
        bob.append(t)
        
both.sort(reverse=True)
alice.sort(reverse=True)
bob.sort(reverse=True)
    
cnt = time = 0 
    
while cnt < k and both and alice and bob:
    if both[-1] <= alice[-1] + bob[-1]:
        time += both.pop()
    else:
        time += alice.pop() + bob.pop()
    cnt += 1
            
while cnt < k and both:
    time += both.pop()
    cnt += 1
        
while cnt < k and alice and bob:
    time += alice.pop() + bob.pop()
    cnt += 1
            
if cnt >= k:
    print(time)
else:
    print(-1)