#include <iostream>
using namespace std;

int a, b, c;

int main(){
	cin >> a >> b >> c;
	int sum = a+b+c;
	cout << (sum-a==a||sum-b==b||sum-c==c?"Yes":"No") << endl;
	return 0;
}
