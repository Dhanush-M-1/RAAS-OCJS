#include <iostream>
using namespace std;
int n, m;
int main() {
	cin>>n>>m;
	if (n>9 or m>9) cout<<-1<<endl;
	else cout<<n*m<<endl;
}