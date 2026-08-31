for _ in " "*int(input()):
  n=int(input())
  lst=[]
  for i in range(n):
    s=list(input())
    lst.append(s)
  
  if lst[1][0] == "0" and lst[0][1] == "1" and lst[n-2][n-1]=="0" and lst[n-1][n-2]=="1":
      print(2)
      print(2,1)
      print(n,n-1)
  elif lst[1][0] == "1" and lst[0][1] == "0" and lst[n-2][n-1]=="1" and lst[n-1][n-2]=="1":
      print(1)
      print(2,1)
  elif lst[1][0] == "1" and lst[0][1] == "0" and lst[n-2][n-1]=="0" and lst[n-1][n-2]=="1":
      print(2)
      print(2,1)
      print(n-1,n)
  elif lst[1][0] == "0" and lst[0][1] == "1" and lst[n-2][n-1]=="1" and lst[n-1][n-2]=="0":
      print(2)
      print(2,1)
      print(n-1,n)

  elif lst[1][0] == "1" and lst[0][1] == "0" and lst[n-2][n-1]=="0" and lst[n-1][n-2]=="0":
      print(1)
      print(1,2)

  elif lst[1][0] == "1" and lst[0][1] == "0" and lst[n-2][n-1]=="1" and lst[n-1][n-2]=="0":
      print(2)
      print(2,1)
      print(n,n-1)

  elif lst[1][0] == "1" and lst[0][1] == "1" and lst[n-2][n-1]=="0" and lst[n-1][n-2]=="0":
      print(0)

  elif lst[1][0] == "1" and lst[0][1] == "1" and lst[n-2][n-1]=="0" and lst[n-1][n-2]=="1":
      print(1)
      print(n,n-1)

  elif lst[1][0] == "1" and lst[0][1] == "1" and lst[n-2][n-1]=="1" and lst[n-1][n-2]=="0":
      print(1)
      print(n-1,n)

  elif lst[1][0] == "1" and lst[0][1] == "1" and lst[n-2][n-1]=="1" and lst[n-1][n-2]=="1":
      print(2)
      print(2,1)
      print(1,2)
  elif lst[1][0] == "0" and lst[0][1] == "0" and lst[n-2][n-1]=="0" and lst[n-1][n-2]=="0":
      print(2)
      print(2,1)
      print(1,2)


  elif lst[1][0] == "0" and lst[0][1] == "0" and lst[n-2][n-1]=="0" and lst[n-1][n-2]=="1":
      print(1)
      print(n-1,n)

  elif lst[1][0] == "0" and lst[0][1] == "1" and lst[n-2][n-1]=="1" and lst[n-1][n-2]=="1":
      print(1)
      print(1,2)
  
  elif lst[1][0] == "0" and lst[0][1] == "0" and lst[n-2][n-1]=="1" and lst[n-1][n-2]=="0":
      print(1)
      print(n,n-1)
  
  elif lst[1][0] == "0" and lst[0][1] == "0" and lst[n-2][n-1]=="1" and lst[n-1][n-2]=="1":
      print(0)

  elif lst[1][0] == "0" and lst[0][1] == "1" and lst[n-2][n-1]=="0" and lst[n-1][n-2]=="0":
      print(1)
      print(2,1)
  

  
    

