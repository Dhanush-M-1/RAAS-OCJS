def seq(k, s1, s2):
    i = 0
    j = 0
    # l = len(s1)+len(s2)
    s = []
    while True:
        if i >= len(s1):
            break
        if j >= len(s2):
            break
            
        if s1[i] <= k:
            s.append(s1[i])
            if s1[i] == 0:
                k+= 1

            i+=1

        elif s2[j] <= k:
            s.append(s2[j])
            if s2[j] == 0:
                k+=1
            j+= 1
        else:
            return [-1]

    
    while i < len(s1):
        if s1[i] <= k:
            s.append(s1[i])
            if s1[i] == 0:
                k+= 1

            i+=1
        else:
            return [-1]

    while j < len(s2):
        if s2[j] <= k:
            s.append(s2[j])
            if s2[j] == 0:
                k+=1
            j+= 1
        else:
            return [-1]
    return s

def draw(a):
    for i in range(len(a)):
        print(a[i], end=' ')
    print()

if __name__=="__main__":

    N = int(input())
    for i in range(N):
        whitespace = input()
        k, m, n = list(map(int, input().split()))
        s1 = list(map(int, input().split()))
        s2 = list(map(int, input().split()))
        draw(seq(k, s1, s2))