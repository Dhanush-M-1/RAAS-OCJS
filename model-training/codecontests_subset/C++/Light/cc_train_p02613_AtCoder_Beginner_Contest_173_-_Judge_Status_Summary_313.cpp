#include<iostream>
#include<map>
using namespace std;

int main()
{
	int num[4];
	int n;
	cin>>n;
	map<string, int> m;
	string s;
	while(n--)
	{
		cin>>s;
		m[s]++;
	}
	cout<<"AC x "<<m["AC"]<<endl;
	cout<<"WA x "<<m["WA"]<<endl;
	cout<<"TLE x "<<m["TLE"]<<endl;
	cout<<"RE x "<<m["RE"]<<endl;
	return 0;
}