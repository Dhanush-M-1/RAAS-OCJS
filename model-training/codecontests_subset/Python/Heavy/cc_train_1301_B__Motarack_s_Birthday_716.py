for _ in range(int(input())):
       n = int(input())
       a = list(map(int, input().split()))
       if max(a) == -1:
              print(0, 1)
              continue
       x = []
       mi = 0
       for i in range(0, n):
              if i > 0 and min(a[i], a[i-1]) != -1:
                     mi = max(mi, abs(a[i]-a[i-1]))
              if a[i] == -1:
                     if i > 0 and a[i-1] != -1:
                            x.append(a[i-1])
                     if i < n-1 and a[i+1] != -1:
                            x.append(a[i+1])
       ans = (min(x)+max(x))//2
       for i in x:
              mi = max(mi, i-ans)
       print(mi, ans)
