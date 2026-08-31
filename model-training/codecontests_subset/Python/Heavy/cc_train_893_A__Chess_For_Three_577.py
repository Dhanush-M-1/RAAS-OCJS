# cook your dish here
n = int(input())

t = [int(input()) for _ in range(n)]

flag = True

i = 1
mark = 1 if t[0] == 2 else 2
playing = [t[0],3]
if t[0] == 3:
    flag = False
    print("NO")
    i = n+1

while(i<n):
    if t[i] == mark:
        print("NO")
        flag = False
        break
        
    else:
        if t[i] in playing:
            u = mark
            mark = playing.pop(abs(1-playing.index(t[i])))
            playing.append(u)
            i += 1
            continue
        else:
            mark = playing.pop(abs(1-playing.index(t[i])))
            playing.append = t[i]
            i += 1
            continue
    
if flag == True:
    print("Yes")