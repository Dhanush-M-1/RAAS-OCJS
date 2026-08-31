def gcd(a,b):
  while b:
    a,b=b,a%b
  return a
T=int(input())
 
Query=[]
for i in range(T):
  Query.append(list(map(int,input().split())))
 
for i in range(T):
  while(True):
    if Query[i][0]%Query[i][1]>Query[i][2] or Query[i][0]<Query[i][1] or Query[i][1]>Query[i][3]:
      print('No')
      break;
    G=gcd(Query[i][1],Query[i][3]) #この倍数分の増減のみ考えれば良い
    '''
    A,B,C,DがQuery[i]の0,1,2,3に対応
    BmodG,DmodGは0(GはB,Dの約数であるため)よりmodGの世界で個数の増減はない。昼の購入で0個減少。夜の仕入れで0個増加。
    つまり、初期個数をAmodGとすると、個数は一定
    出現する可能性のあるBは買う個数であり、B-Gを考えると、買いきれない個数で出現しうる最大の個数が求まる。
    但し、初期個数を考える必要がある。
    初期個数によってループする幅が一緒でも取りうる値は異なる。
    
    例：
    B=24,C=19,D=36 この時,G=12
    
    A=31の場合 AmodG(本来の個数)
    7(31)→7(7)→7(43)→7(19)→7(31)→...
    A=30の場合 AmodG(本来の個数)
    6(30)→6(6)→6(42)→6(18)→6(30)→...
    
    Bを超えない最大数について、初期個数を考慮すると、B-G+AmodGとなる。
    G>AmodGであるため、この数が購入数Bを超えることはない
    つまり、B-G+AmodG>CならばNo,そうでなければYes
    '''
    if Query[i][1]-G+Query[i][0]%G>Query[i][2]:
      print('No')
      break;
    else:
      print('Yes')
      break;