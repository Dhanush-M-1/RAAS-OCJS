#include <iostream>
using namespace std;
int main(){
  int a,b;
	cin >> a >> b;

	(a>=10 || b>=10) ? cout << -1 << '\n' : cout << a*b << '\n';

}