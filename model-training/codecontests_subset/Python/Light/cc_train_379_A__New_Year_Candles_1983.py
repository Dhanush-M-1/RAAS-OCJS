def main():
   n,div=map(int,input().split())
   somme=0
   morceauRestant=0
   while n!=0:
      somme+=n
      morceau=morceauRestant+n
      n=morceau//div
      morceauRestant=morceau%div
   print(somme)   
main()