n = int(input())
a = []
play = '12'
for i in range(n):
    a.append(int(input()))
i = 0
check = [False] * n
while i != n:
    if a[i] == int(play[0]) or a[i] == int(play[1]):
        if play.count('1') == 1 and play.count('2') == 1:
            play = (str(a[i]) +'3')

        elif play.count('1') == 1 and play.count('3') == 1:
            play = (str(a[i]) +'2')  

        elif play.count('3') == 1 and play.count('2') == 1:
            play = (str(a[i]) +'1')
        i += 1  
    else:
        print('NO')
        break
if i == n:
    print('YES')
        

 
       
