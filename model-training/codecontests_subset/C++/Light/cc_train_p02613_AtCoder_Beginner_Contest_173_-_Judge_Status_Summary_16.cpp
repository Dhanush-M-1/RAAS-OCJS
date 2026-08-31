#include <bits/stdc++.h>
using namespace std;

int main() {
	int n;
	cin>>n;
	unordered_map<string,int>m;
	string a;
	while(n--){
		cin>>a;
		m[a]++;
	}
	cout<<"AC x "<<m["AC"]<<endl;
		cout<<"WA x "<<m["WA"]<<endl;
			cout<<"TLE x "<<m["TLE"]<<endl;
				cout<<"RE x "<<m["RE"]<<endl;


	
	return 0;
}