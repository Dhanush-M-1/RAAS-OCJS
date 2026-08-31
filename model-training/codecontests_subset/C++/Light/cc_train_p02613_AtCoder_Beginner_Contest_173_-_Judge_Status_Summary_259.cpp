#include<bits/stdc++.h>
#define nl '\n'
using namespace std;


int main(){
	int n;
	cin>>n;
	string s;
	map<string,int> m;
	while(n--){
		cin>>s;
		m[s]++;
	}

	cout<<"AC x "<<m["AC"]<<nl;
	cout<<"WA x "<<m["WA"]<<nl;
	cout<<"TLE x "<<m["TLE"]<<nl;
	cout<<"RE x "<<m["RE"]<<nl;
	
	return 0;
}