S = int(input())
A = input()

As = A.count('A')
Fs = A.count('F')
Is = A.count('I')

ans = 0

if Is > 1:
    print(ans)

else:
    ans += Is
    if Is == 0:
        ans += As
    print(ans)