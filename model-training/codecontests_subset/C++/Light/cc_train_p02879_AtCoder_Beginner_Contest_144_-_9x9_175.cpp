#include<iostream>
using namespace std;

int main(){
  int A, B;
  cin >> A >> B;
  cout << (A>9 || B>9 ? -1 : A*B) << endl;
  return 0;
}
