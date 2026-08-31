#include<iostream>
using namespace std;
int main()
{
  int A,B;
  cin >> A >> B ;

  if(A>9 || A<1 || B>9 || B<1)cout<<"-1";
  else cout<<A*B;
}