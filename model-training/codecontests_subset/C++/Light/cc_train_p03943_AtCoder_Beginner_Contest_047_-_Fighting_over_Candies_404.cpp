#include <iostream>
using namespace std;

int main() {
	int a,b,c;
	cin>>a>>b>>c;
	if(a+c==b||b+a==c||c+b==a)cout << "Yes" << endl;
	else cout << "No" << endl;
	return 0;
}