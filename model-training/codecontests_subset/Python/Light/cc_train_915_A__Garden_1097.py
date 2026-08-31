n, k = map(int, input().split())
cup = list(map(int, input().split()))
cup.sort(reverse=True)
for i in cup:
  w = 0
  while(w<k):
    w = w +int(i)
    if(w==k):
      print(k//int(i))
      break;
  if(w==k):
    break;