def Grid(S):
    xmin = [0, [-1]]
    xmax = [0, [-1]]
    ymin = [0, [-1]]
    ymax = [0, [-1]]
    y_s = 0
    x_s = 0
    n = len(S)
    for i in range(n):
        c = S[i]
        if c=='W':
            y_s+=1
        elif c=='S':
            y_s-=1
        elif c=='A':
            x_s-=1
        else:
            x_s+=1
        if x_s==xmin[0]:
            xmin[1].append(i)
        elif x_s < xmin[0]:
            xmin = [x_s, [i]]
            
        if x_s==xmax[0]:
            xmax[1].append(i)
        elif x_s > xmax[0]:
            xmax = [x_s, [i]]
        if y_s==ymin[0]:
            ymin[1].append(i)
        elif y_s < ymin[0]:
            ymin = [y_s, [i]]
            
        if y_s==ymax[0]:
            ymax[1].append(i)
        elif y_s > ymax[0]:
            ymax = [y_s, [i]]
    return [xmin, xmax, ymin, ymax]

def process(S):
    A, B, C, D = Grid(S)
    a, al = A
    b, bl = B
    c, cl = C
    d, dl = D
    answer = (b-a+1)*(d-c+1)
    if bl[-1] < al[0]-1 or al[-1] < bl[0]-1:
        answer = min(answer, (b-a)*(d-c+1))
    if dl[-1] < cl[0]-1 or cl[-1] < dl[0]-1:
        answer = min(answer, (b-a+1)*(d-c))
    return answer

t = int(input())
for i in range(t):
    S =  input()
    print(process(S))