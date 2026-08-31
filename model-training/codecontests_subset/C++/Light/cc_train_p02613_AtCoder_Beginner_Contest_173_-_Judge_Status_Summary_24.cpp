#include <iostream>
using namespace std;

int main() {
	int n;
	cin>>n;
	
	int a[26]={0};
	string s;
	while(n--)
	{
		cin>>s;
		a[s[0]%65]++;
	}
    cout<<"AC x "<<a['A'%65]<<endl;
    cout<<"WA x "<<a['W'%65]<<endl;
    cout<<"TLE x "<<a['T'%65]<<endl;
    cout<<"RE x "<<a['R'%65]<<endl;
	return 0;
}