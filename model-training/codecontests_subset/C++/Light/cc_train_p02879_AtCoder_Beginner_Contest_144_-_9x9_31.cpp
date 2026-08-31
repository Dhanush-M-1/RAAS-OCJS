#include <iostream>
using namespace std;
int main(void){
  int a, b;
  cin >> a >> b;
  cout << (a <= 9 && b <= 9 ? a*b : -1) << endl;
}