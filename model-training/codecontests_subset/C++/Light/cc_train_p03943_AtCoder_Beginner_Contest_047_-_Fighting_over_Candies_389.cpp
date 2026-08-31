#include <iostream>
using namespace std;
 
int main() {
	int a,b,c;
	cin>>a>>b>>c;
	if ((a==b+c)or(c==a+b)or(b==a+c)) cout <<"Yes" << endl;
	else cout <<"No" << endl;
}