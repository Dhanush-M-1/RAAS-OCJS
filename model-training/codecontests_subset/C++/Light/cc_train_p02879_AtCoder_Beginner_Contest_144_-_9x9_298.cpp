#include <iostream>

using namespace std;

int main()
{
  int A, B;
  cin >> A >> B;
  
  cout << (max(A, B) <= 9 ? A*B : -1);
  return 0;
}